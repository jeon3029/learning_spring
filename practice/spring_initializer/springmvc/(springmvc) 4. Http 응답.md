# Http 응답

## Http 응답 : 정적리소스, 뷰 템플릿

스프링(서버)에서 응답 데이터를 만드는 방법은 크게 3가지이다.

- 정적 리소스
  - 웹 브라우저에 정적인 HTML, css, js을 제공할 때는, 정적 리소스를 사용한다.
- 뷰 템플릿 사용
  - 웹 브라우저에 동적인 HTML을 제공할 때는 뷰 템플릿을 사용한다.
- HTTP 메시지 사용
  - HTTP API를 제공하는 경우에는 HTML이 아니라 데이터를 전달해야 하므로, HTTP 메시지 바디에 JSON 같은 형식으로 데이터를 실어 보낸다.

### 정적 리소스

- 스프링 부트는 클래스패스의 다음 디렉토리에 있는 정적 리소스를 제공한다.
  - /static , /public , /resources , /META-INF/resources
  - (예) src/main/resources/static/basic/hello-form.html
    - <http://localhost:8080/basic/hello-form.html>
    - 해당 url 로 접근 가능

### 뷰 템플릿

- 뷰 템플릿 경로
  - src/main/resources/templates
- 뷰 템플릿 생성
  - src/main/resources/templates/response/hello.html
  - [hello.html](./src/main/resources/templates/response/hello.html)
- 컨드롤러 작성 : [ResponseViewController](./src/main/java/hello/springmvc/basic/response/ResponseViewController.java)
  - @ResponseBody 가 없으면 response/hello 로 뷰 리졸버가 실행되어서 뷰를 찾고, 렌더링 한다.
  - `void`를 반환하는 경우
    - @Controller 를 사용하고, HttpServletResponse , OutputStream(Writer) 같은 HTTP 메시지바디를 처리하는 파라미터가 없으면 요청 URL을 참고해서 논리 뷰 이름으로 사용
      - **권장하지 않는다.**

### Thymeleaf 스프링 부트 설정

이미 설정되어 있지만(<https://start.spring.io/>) 추가 설정 필요할 경우 위하여 참고
`build.gradle`

```gradle
`implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'`
```

기본 설정값(변경 필요할 때만 설정)
`application.properties`

```properties
spring.thymeleaf.prefix=classpath:/templates/
spring.thymeleaf.suffix=.html
```

공식 문서
> <https://docs.spring.io/spring-boot/docs/2.4.3/reference/html/appendix-application-properties.html#common-application-properties-templating>

## HTTP 응답 - 메시지 바디, 상태코드

HTTP 요청에서 응답까지 대부분 다루었지만 정리하는 목적
- 정적 리소스나 뷰템플릿을 거치지 않고 바로 전달하는 경우

- [ResponseBodyController](./src/main/java/hello/springmvc/basic/response/ResponseBodyController.java)
- responseBodyV1
  - HttpServletResponse 객체를 통해서 HTTP 메시지 바디에 직접 ok 응답 메시지를 전달한다.
- responseBodyV2
  - ResponseEntity 엔티티는 HttpEntity 를 상속 받았는데, HttpEntity는 HTTP 메시지의 헤더, 바디 정보를 가지고 있다. ResponseEntity 는 여기에 더해서 HTTP 응답 코드를 설정할 수 있다.
- responseBodyV3
  - @ResponseBody 를 사용하면 view를 사용하지 않고, HTTP 메시지 컨버터를 통해서 HTTP 메시지를 직접 입력할 수 있다. ResponseEntity 도 동일한 방식으로 동작한다.
- responseBodyJsonV1
  - ResponseEntity 를 반환한다. HTTP 메시지 컨버터를 통해서 JSON 형식으로 변환되어서 반환된다.
- responseBodyJsonV2
  - ResponseEntity 는 HTTP 응답 코드를 설정할 수 있는데, @ResponseBody 를 사용하면 이런 것을 설정하기 까다롭다.
  - @ResponseStatus(HttpStatus.OK) 애노테이션을 사용하면 응답 코드도 설정할 수 있다.
  - 동적으로 응답코드 설정하고 싶다면, `ResponseEntity` 사용하면 된다.