FROM eclipse-temurin:20-jdk as build
WORKDIR /app
# Copy your application source code and build it
COPY . .
RUN ./gradlew bootJar
#RUN chmod +x gradlew
#RUN ./gradlew clean
#RUN ./gradlew build

# Stage 2: Create the final image
FROM eclipse-temurin:20-jdk
WORKDIR /app
# Copy the built JAR from the build stage
COPY --from=build /app/build/libs/MyBooks.jar app.jar

# Specify the command to run your application
CMD ["java", "-jar", "app.jar"]