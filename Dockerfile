FROM tomcat:8.0.20-jre8
COPY target/maven-web-app*.jar /usr/local/tomcat/webapps/DevOpsDemoProject.jar