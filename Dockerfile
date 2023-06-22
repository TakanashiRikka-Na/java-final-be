# 基于 OpenJDK 17 镜像
FROM openjdk:17-jdk-alpine3.13

# 设置工作目录
WORKDIR /app

#依赖项复制 这里我用的 gradle 构建
COPY /build/libs/final_server-0.0.2-fix.jar app.jar

#暴露端口
EXPOSE 8080

#运行 jar
CMD ["java","-jar","app.jar"]
