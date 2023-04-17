FROM openjdk:20
ADD target/*.jar WishlistApp-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","WishlistApp-0.0.1-SNAPSHOT.jar"]
