FROM openjdk:8
ADD target/MovieRental.jar MovieRental.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "MovieRental.jar"]