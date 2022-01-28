pipeline {
  agent any
  stages {
     stage("Cleaning Stage") {
      steps {
        bat "mvn clean"
      }
    }
    stage("Testing stage") {
      steps {
        bat "mvn test"
      }
    }
    stage("Packaging stage") {
      steps {
        bat "mvn package"
      }
    }
   /* stage("sonarqube stage"){
       steps {
         bat "mvn package sonar:sonar"
       }
    } */
    stage("Consolidate Results") {
      steps {
        input("Do you want to capture results?")
        junit'**/target/surefire-reports/TEST-*.xml'
        archive 'target/*.jar'
      }
    }
  }
}
