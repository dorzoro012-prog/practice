// File: Jenkinsfile — Scripted build, test, Docker image push, optional email.
// Prerequisites: Jenkins agent has Docker CLI AND daemon access, Git, Maven, JDK.
// Jenkins credential type: Username with password, ID 'dockerhub-creds'; password = Docker Hub access token.
// Configure YOUR_DOCKERHUB_USER and repo URL; correct the branch after checking it.
node {
  def imageName = 'YOUR_DOCKERHUB_USER/se-lab-app'
  def tagName = "${env.BUILD_NUMBER}"
  try {
    stage('Checkout') { git branch: 'main', url: 'REPOSITORY_URL' }
    stage('Build and Test') {
      if (isUnix()) { sh 'mvn -B clean verify' } else { bat 'mvn -B clean verify' }
    }
    stage('Docker Build') {
      if (isUnix()) { sh "docker build -t ${imageName}:${tagName} ." }
      else { bat "docker build -t ${imageName}:${tagName} ." }
    }
    stage('Docker Push') {
      withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', usernameVariable: 'DH_USER', passwordVariable: 'DH_TOKEN')]) {
        if (isUnix()) {
          sh """set +x
            echo "\$DH_TOKEN" | docker login -u "\$DH_USER" --password-stdin
            docker push ${imageName}:${tagName}
            docker logout
          """
        } else {
          bat """@echo off
            echo %DH_TOKEN% | docker login -u %DH_USER% --password-stdin
            docker push ${imageName}:${tagName}
            docker logout
          """
        }
      }
    }
  } catch (err) {
    currentBuild.result = 'FAILURE'
    echo "Failed: ${err}"
    // Optional after installing/configuring Email Extension and SMTP:
    // emailext to: 'TEAM_EMAIL@example.com', subject: "FAILED: ${env.JOB_NAME} #${env.BUILD_NUMBER}", body: "${env.BUILD_URL}console"
    throw err
  } finally {
    archiveArtifacts artifacts: 'target/*.war,target/*.jar', allowEmptyArchive: true
  }
}
// Requires a real Dockerfile adapted to artifact type; no pipeline can invent a WAR from a JAR.
// GitHub webhook: https://PUBLIC_JENKINS_URL/github-webhook/; push trigger must be enabled in Jenkins.
// If webhook not reachable from GitHub, use Poll SCM until tunneling/public endpoint is configured.
