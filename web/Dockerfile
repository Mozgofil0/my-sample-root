FROM bellsoft/liberica-openjdk-alpine:11.0.15 as builder
WORKDIR app
ARG JAR_FILE=target/web.jar
COPY ${JAR_FILE} app.jar
RUN java -Djarmode=layertools -jar app.jar extract

FROM bellsoft/liberica-openjdk-alpine:11.0.15 as runtime
COPY --from=builder app/dependencies/ ./
COPY --from=builder app/spring-boot-loader/ ./
COPY --from=builder app/snapshot-dependencies/ ./
COPY --from=builder app/application/ ./

FROM runtime as development
EXPOSE 8000
ENTRYPOINT ["java","-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:8000","org.springframework.boot.loader.JarLauncher"]

FROM runtime as production
ENTRYPOINT ["java","org.springframework.boot.loader.JarLauncher"]