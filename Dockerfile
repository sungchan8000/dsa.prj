FROM eclipse-temurin:11
ADD build/libs/dsa.prj-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]

