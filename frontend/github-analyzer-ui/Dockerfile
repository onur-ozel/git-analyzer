FROM node:alpine AS angularBuild

WORKDIR /app

COPY ./src/ui-angular-app .

RUN npm install && \
  npm run build

FROM openjdk:8-jdk-alpine as mavenBuild
WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src
COPY --from=angularBuild /app/dist/* /src/main/resources/static/

RUN ./mvnw install -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG DEPENDENCY=/workspace/app/target/dependency
COPY --from=mavenBuild ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=mavenBuild ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=mavenBuild ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","com.onur.scout24.GitHubAnalyzerUI"]