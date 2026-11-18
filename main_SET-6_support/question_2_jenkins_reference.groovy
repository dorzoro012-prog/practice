// File: Jenkinsfile — Scripted Pipeline (agent must have Git, Maven, JDK)
node {
  try {
    stage('Checkout') {
      git branch: 'main', url: 'REPOSITORY_URL' // Replace with actual default branch
    }
    stage('Build') { if (isUnix()) { sh 'mvn -B clean compile' } else { bat 'mvn -B clean compile' } }
    stage('Test') { if (isUnix()) { sh 'mvn -B test' } else { bat 'mvn -B test' } }
    stage('Package') { if (isUnix()) { sh 'mvn -B package' } else { bat 'mvn -B package' } }
    stage('Archive') { archiveArtifacts artifacts: 'target/*.war,target/*.jar', allowEmptyArchive: false }
  } catch (err) {
    currentBuild.result = 'FAILURE'
    echo "Pipeline failed: ${err}"
    throw err // Stops later stages and marks failed
  }
}
// Jenkins Pipeline job > Pipeline script from SCM > Git > URL > Script Path Jenkinsfile.
// Configure GitHub hook trigger via job or a supported SCM integration;
// GitHub webhook: https://PUBLIC_JENKINS_URL/github-webhook/ (must be publicly reachable).
// Install Pipeline, Git, Maven Integration, GitHub plugins as required.
