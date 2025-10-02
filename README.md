# LG CNS 스프링 연습?

## Java install
```bash
$ sudo apt install openjdk-17-jdk -y
```

## Build
```bash
$ ./gradlew clean bootJar
```

## Run
```bash
$ java -jar build/libs/simple_spring-<VERSION>.jar
```

## Test
```bash
$ curl localhost:8080/hello
{"koreaTime":"2025-10-01T14:12:32.832419682+09:00[Asia/Seoul]","timestamp":"1759295552832","message":"Hello, World!"}
```

## Remote Run
```bash
# scp -i <KEY.pem> start.sh ubuntu@<SERVER-IP>:~/app/spring-rest-api

$ ssh -i <KEY.pem> ubuntu@<SERVER-IP> "cd ~/app/spring-rest-api/;./start.sh"
```

## Remote Stop
```bash
# scp -i <KEY.pem> stop.sh ubuntu@<SERVER-IP>:~/app/spring-rest-api

$ ssh -i <KEY.pem> ubuntu@<SERVER-IP> "cd ~/app/spring-rest-api/;./stop.sh"
```

## Docker
### Ref
- https://spring.io/guides/gs/spring-boot-docker
- openJDK 17
```bash
$ sudo docker build --build-arg JAR_FILE=build/libs/\*.jar -t <DOCKERHUB-REPO>/simple-spring:<TAG> .
$ sudo docker run -d --name simple-spring -p 8080:8080 <DOCKER-IMAGE> 
```

## Jenkins
```bash
./gradlew clean bootJar
pwd
ls build/libs

# start.sh / stop.sh 복사
scp -i /var/jenkins_home/keys/aws-lgcns.pem \
-o StrictHostKeyChecking=no \
start.sh ubuntu@54.193.112.184:~/app/spring-rest-api

scp -i /var/jenkins_home/keys/aws-lgcns.pem \
-o StrictHostKeyChecking=no \
stop.sh ubuntu@54.193.112.184:~/app/spring-rest-api

# 기존 java 프로세스 정지
ssh -i /var/jenkins_home/keys/aws-lgcns.pem \
-o StrictHostKeyChecking=no \
ubuntu@54.193.112.184 \
"cd ~/app/spring-rest-api/;./stop.sh"

# 기존 *.jar 파일 삭제
ssh -i /var/jenkins_home/keys/aws-lgcns.pem \
-o StrictHostKeyChecking=no \
ubuntu@54.193.112.184 \
"find /home/ubuntu/app/spring-rest-api -name "*jar" -delete"

# 빌드한 *.jar 파일을 app.jar 로 변경
mv build/libs/*.jar build/libs/app.jar

# aws instance에 복사
scp -i /var/jenkins_home/keys/aws-lgcns.pem \
-o StrictHostKeyChecking=no \
build/libs/app.jar \
ubuntu@54.193.112.184:~/app/spring-rest-api

# start.sh 실행
ssh -i /var/jenkins_home/keys/aws-lgcns.pem \
-o StrictHostKeyChecking=no \
ubuntu@54.193.112.184 \
"cd ~/app/spring-rest-api/;./start.sh"
```