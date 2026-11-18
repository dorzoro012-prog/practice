// Jenkins Scripted Pipeline with fail-only Email Extension notification
// Jenkins > Manage Jenkins > Plugins: install Email Extension (email-ext).
// Jenkins > Manage Jenkins > System > Extended E-mail Notification: set SMTP server,
// port, TLS/SSL, authentication (app password/SMTP credential), default sender.
// Replace TEAM_EMAIL and verify 'Test configuration' can send a message.
node {
  try {
    stage('Checkout') { git branch: 'main', url: 'REPOSITORY_URL' }
    stage('Build') { if (isUnix()) sh 'mvn -B clean compile'; else bat 'mvn -B clean compile' }
    stage('Test') { if (isUnix()) sh 'mvn -B test'; else bat 'mvn -B test' }
    stage('Package') { if (isUnix()) sh 'mvn -B package'; else bat 'mvn -B package' }
  } catch (e) {
    currentBuild.result = 'FAILURE'
    emailext to: 'TEAM_EMAIL@example.com',
      subject: "FAILED: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
      body: "Build failed. Inspect ${env.BUILD_URL}console"
    throw e
  }
}
// To demonstrate an intentional failure, temporarily add a separate stage with
// if (isUnix()) sh 'exit 1'; else bat 'exit /b 1' ; then remove it.
// For both success and failure notifications: add emailext in success path after
// Package, and keep fail-only notification inside catch.
