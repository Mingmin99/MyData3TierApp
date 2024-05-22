# 단계 1: 빌드 단계
FROM gradle:7.5.1-jdk17 AS build

# 작업 디렉토리 설정
WORKDIR /home/gradle/project

# 필요한 파일들을 복사
COPY . .

# 프로젝트 빌드 (JAR 파일 생성)
RUN gradle build --no-daemon --info --stacktrace

# 단계 2: 런타임 단계
FROM openjdk:17

# 작업 디렉토리 설정
WORKDIR /app

# 빌드 단계에서 생성된 JAR 파일을 런타임 이미지로 복사
COPY --from=build /home/gradle/project/build/libs/*.jar /app/app.jar

# 애플리케이션이 사용할 포트 번호 설정
EXPOSE 8080

# 컨테이너 시작 시 실행할 Java 애플리케이션
CMD ["java", "-jar", "/app/app.jar"]
