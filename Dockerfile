FROM openjdk:17
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} search-basic.jar
ENTRYPOINT ["java","-jar","/search-basic.jar"]
