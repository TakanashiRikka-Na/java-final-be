# java-final-be Java期末大作业 宿舍管理系统 SpringBoot 后端项目

## 部署方法
```shell
./gradlew  bootJar

docker buildx build -t <name>:<version> -f Dockerfile .

docker run -p 8080:8080 -d  <name>:<version>

```
### <u>记得在 build.gradle 中改 version！！！！</u>
