# 使用官方的 OpenJDK 17 基础镜像
FROM openjdk:21-jdk-slim

# 设置工作目录
WORKDIR /app

# 将本地的 jar 文件复制到容器中
COPY ./sb3-mybatis-plus.jar /app/sb3-mybatis-plus.jar

# 暴露应用运行的端口
EXPOSE 9001

RUN ln -snf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN echo "Asia/Shanghai" > /etc/timezone

# 启动 Spring Boot 应用
ENTRYPOINT ["java", "-jar", "/app/sb3-mybatis-plus.jar","--spring.config.location=/app/config/application.yml"]