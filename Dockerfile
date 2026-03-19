FROM amazoncorretto:21
COPY target/daw-0.0.1-SNAPSHOT.jar daw-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/daw-0.0.1-SNAPSHOT.jar"]