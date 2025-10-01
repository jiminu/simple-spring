# LG CNS 스프링 연습?

## build
```bash
$ ./gradlew clean bootJar
```

## Run
```bash
$ java -jar build/libs/simple_spring-0.1.0.jar
```

## Test
```bash
$ curl localhost:8080/hello
{"koreaTime":"2025-10-01T14:12:32.832419682+09:00[Asia/Seoul]","timestamp":"1759295552832","message":"Hello, World!"}
```
