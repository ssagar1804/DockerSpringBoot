FROM maven:latest AS MAVEN_TOOL_CHAIN
VOLUME "$USER_HOME_DIR/.m2"
COPY ./pom.xml ./pom.xml
# build all dependencies for offline use
RUN mvn dependency:go-offline -B
# copy your other files
COPY ./src ./src
# build for release
RUN mvn clean install -DskipTests

FROM tomcat:latest
VOLUME /tmp
RUN rm -rf /usr/local/tomcat/webapps/docker-springboot.war
COPY --from=MAVEN_TOOL_CHAIN target/docker-springboot.war /usr/local/tomcat/webapps/docker-springboot.war
EXPOSE 8086
ENTRYPOINT [ "sh", "-c", "java -Dspring.profiles.active=docker -Djava.security.egd=file:/dev/./urandom -jar /usr/local/tomcat/webapps/docker-springboot.war" ]