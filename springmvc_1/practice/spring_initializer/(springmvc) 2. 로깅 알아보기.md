# 로깅 알아보기

- 운영시스템에서는 sysout 사용하지 않는다

## 로깅 라이브러리

- 스프링 부트 라이브러리를 사용하면 스프링 부트 로깅 라이브러리 `spring-boot-starter-logging`가 함께 포함된다
  - SLF4J : <http://www.slf4j.org>
  - Logback : <http://logback.qos.ch>
- 로그 라이브러리는 Logback, Log4J, Log4J2 등등 수 많은 라이브러리가 있는데, 그것을 통합해서 인터페이스로 제공하는 것이 바로 SLF4J 라이브러리
  - 실무에서는 스프링 부트가 기본으로 제공하는 Logback을 대부분 사용

## 로그 선언 및 호출

```java
//선언
private Logger log = LoggerFactory.getLogger(getClass());
private static final Logger log = LoggerFactory.getLogger(Xxx.class)

//lombok
@Slf4j

//호출
log.info("hello");
```

- [LogTestController](./springmvc/src/main/java/hello/springmvc/basic/LogTestController.java)
  - LEVEL : TRACE > DEBUG > INFO > WARN > ERROR
  - 개발 서버는 debug 출력
  - 운영 서버는 info 출력

- [application.properties](./springmvc/src/main/resources/application.properties)

- 올바른 사용법
  - `log.debug("data="+data");`
    - 로깅레벨이 debug 보다 높을 때에도 문자 더하기 연산이 수행됨(출력이 안되어도)
  - `log.debug("data = {},data);`
    - 의미없는 연산 발생하지 않음

## 로그 사용시 장점

- 쓰레드 정보, 클래스 이름 같은 `부가 정보`를 함께 볼 수 있고, 출력 모양을 조정할 수 있다.
- `로그 레벨`에 따라 개발 서버에서는 모든 로그를 출력하고, 운영서버에서는 출력하지 않는 등 로그를 상황에 맞게 조절할 수 있다.
- 시스템 아웃 콘솔에만 출력하는 것이 아니라, 파일이나 네트워크 등, 로그를 `별도의 위치`에 남길 수 있다. 특히 파일로 남길 때는 일별, 특정 용량에 따라 로그를 분할하는 것도 가능하다.
- `성능`도 일반 System.out보다 좋다. (내부 버퍼링, 멀티 쓰레드 등등) 그래서 실무에서는 꼭 로그를 사용해야 한다.

> 참고
> <https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-logging>