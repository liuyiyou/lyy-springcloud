

# 本地Docker

cd register-center-eureka

mvn clean compile jib:dockerBuild -DskipTests

## 本地运行(如果是开发环境则要将docker-compse.yml 存放到指定位置)
docker-compose -f src/main/docker/docker-compose-docker.yml up -d