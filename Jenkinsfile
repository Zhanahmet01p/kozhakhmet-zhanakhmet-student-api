pipeline {
  agent any
  environment {
    IMAGE_NAME = 'kozhakhmet-zhanakhmet-student-api:v1.0-kozhakhmet-zhanakhmet'
    STUDENT_NAME = 'Zhanakhmet Kozhakhmet'
  }
  stages {
    stage('Checkout') {
      steps { echo "Student: ${STUDENT_NAME}"; checkout scm }
    }
    stage('Build') {
      steps { sh 'gradle --no-daemon clean assemble' }
    }
    stage('Test') {
      steps { sh 'gradle --no-daemon test' }
    }
    stage('Docker Build') {
      steps { sh 'docker build -t "$IMAGE_NAME" .' }
    }
    stage('Verify') {
      steps { sh 'docker image inspect "$IMAGE_NAME" >/dev/null'; sh 'echo "Verified image: $IMAGE_NAME"'; sh 'echo "Student: $STUDENT_NAME"' }
    }
  }
  post {
    success { echo "Pipeline completed successfully for ${STUDENT_NAME}." }
    failure { echo "Pipeline failed. Check the stage and console output." }
  }
}
