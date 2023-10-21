FROM eclipse-temurin:20-jdk AS build
COPY . /app
WORKDIR /app
RUN ./gradlew bootJar
RUN mv -f build/libs/*.jar app.jar

FROM eclipse-temurin:20-jre
ARG PORT
ENV PORT=${PORT}
COPY --from=build /app/app.jar .
RUN useradd runtime
USER runtime
ENTRYPOINT [ "java", "-Dserver.port=${PORT}", "-jar", "app.jar" ]



#FROM eclipse-temurin:20-jdk as build
#WORKDIR /app
## Copy your application source code and build it
#COPY . .
#RUN chmod +x gradlew
#RUN ./gradlew bootJar
##RUN ./gradlew clean
##RUN ./gradlew build
#
## Stage 2: Create the final image
#FROM eclipse-temurin:20-jdk
#WORKDIR /app
## Copy the built JAR from the build stage
#COPY --from=build /app/build/libs/MyBooks.jar app.jar
#
## Specify the command to run your application
#CMD ["java", "-jar", "app.jar"]