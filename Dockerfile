FROM openjdk:8
VOLUME /tmp 
ADD ./target/current-account-service-0.0.1-SNAPSHOT.jar service-current-account.jar
ENTRYPOINT [ "java", "-jar","./service-current-account.jar" ]