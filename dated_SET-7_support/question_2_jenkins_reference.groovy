# PowerShell — on a machine with Git, JDK and Maven installed
java -version
mvn -version
git clone REPOSITORY_URL
cd REPOSITORY_FOLDER
# Inspect pom.xml: packaging should be war for a Tomcat deployment; jar may not be a webapp.
mvn clean test
mvn clean package
# Windows PowerShell: list generated build artifacts
Get-ChildItem .\target -Include *.war,*.jar -Recurse
# Jenkins: New Item > Freestyle project > Source Code Management: Git > repository URL
# Branch Specifier: */main OR */master (use actual branch shown on GitHub)
# Build Triggers: Poll SCM (e.g. H/5 * * * *) OR GitHub hook trigger with reachable webhook
# Build Steps: Invoke top-level Maven targets: clean test package
# Post-build Actions: Archive the artifacts: target/*.war,target/*.jar
# If Jenkins is Dockerized, tools must exist INSIDE Jenkins or on the build agent.
# If a build fails: inspect Console Output and surefire-reports; do not skip tests to fake success.
