FROM adoptopenjdk/openjdk17:alpine-jre as build
WORKDIR /app
# Copy your application source code and build it
COPY . .
RUN chmod +x gradlew
RUN ./gradlew clean
RUN ./gradlew build

# Stage 2: Create the final image
FROM adoptopenjdk/openjdk17:alpine-jre
WORKDIR /app
# Copy the built JAR from the build stage
COPY --from=build /app/build/libs/MyBooks.jar app.jar

# Specify the command to run your application
CMD ["java", "-jar", "app.jar"]