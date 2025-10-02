# LG CNS 스프링 연습?

## build
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
- https://spring.io/guides/gs/spring-boot-docker
- openJDK 17
