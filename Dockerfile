FROM gradle:8.13-jdk21-alpine AS build

WORKDIR /home/gradle/project

COPY . .

RUN chown -R gradle:gradle /home/gradle/project && mkdir -p /tmp/gradle-cache /tmp/gradle-project-cache && chown -R gradle:gradle /tmp/gradle-cache /tmp/gradle-project-cache

USER gradle

ENV GRADLE_USER_HOME=/tmp/gradle-cache

RUN gradle --no-daemon --project-cache-dir /tmp/gradle-project-cache clean test bootJar

FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

RUN addgroup -S appgroup && adduser -S appuser -G appgroup

COPY --from=build /home/gradle/project/build/libs/*.jar app.jar

USER appuser

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
