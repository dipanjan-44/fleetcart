FROM tomcat:9.0

COPY target/fleetcart.war /usr/local/tomcat/webapps/

EXPOSE 8080