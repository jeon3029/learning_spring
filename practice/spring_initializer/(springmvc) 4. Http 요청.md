# Http 요청

## Http 요청 - 기본, 헤더 조회

- 지난번 HttpServletRequest 에서도 헤더정보 뽑는것을 했었다.
- 바로 코드로 알아보자.
- [RequestHeaderController](./springmvc/src/main/java/hello/springmvc/basic/request/RequestHeaderController.java)
- `HttpServletRequest`
- `HttpServletResponse`
- HttpMethod : HTTP 메서드를 조회한다. org.springframework.http.HttpMethod
- Locale : locale 정보 조회
- @RequestHeader MultiValueMap<String, String> headerMap
  - 모든 HTTP 헤더를 MultiValueMap 형식으로 조회한다.
  - @RequestHeader("host") String host
    - 특정 HTTP 헤더를 조회한다. 속성
    - 필수 값 여부: required
    - 기본 값 속성: defaultValue
- @CookieValue(value = "myCookie", required = false) String cookie
  - 특정 쿠키를 조회한다.
    - 필수 값 여부: required
    - 기본 값: defaultValue
- MultiValueMap
  - 하나의 키에 여러 값 받을 수 있음
  - `List<String> values = map.get("keyA");`
> @Controller 참고
> <https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-ann-arguments>
> <https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-ann-return-types>

## Http 요청 파라미터 - 쿼리 파라미터, HTML Form

- Http 요청 메세지를 통해 데이터를 전송하는 방법
  - GET - 쿼리 파라미터
    - /url?username=hello&age=20
    - 메시지 바디 없이, URL의 쿼리 파라미터에 데이터를 포함해서 전달
    - (예) 검색, 필터, 페이징등에서 많이 사용하는 방식
  - POST - HTML Form
    - content-type: application/x-www-form-urlencoded
    - 메시지 바디에 쿼리 파리미터 형식으로 전달 username=hello&age=20
    - (예) 회원 가입, 상품 주문, HTML Form 사용
  - HTTP message body에 데이터를 직접 담아서 요청
    - HTTP API에서 주로 사용, JSON, XML, TEXT
    - 데이터 형식은 주로 JSON 사용
    - POST, PUT, PATCH

- 여기서 GET 쿼리방식, POST Html Form 방식이 요청파라미터 조회 방식이다.

- 코드로 알아보자
- [RequestParamController](./springmvc/src/main/java/hello/springmvc/basic/request/RequestParamController.java)
  - request-param-v1 : HttpServletRequest
    - Test :
      - GET : <http://localhost:8080/request-param-v1?username=hello&age=20>
      - POST Form : [hello-form.html](./servlet/src/main/webapp/basic/hello-form.html)
  - request-param-v2 : @Requestparam
    - requestparam 사용하여 간편하게 사용
    - @ResponseBody : string 을 http body 에 넣어서 보내줌
  - request-param-v3
    - 변수명이 같으면 생략가능
  - request-param-v4
    - 더 간단하게도 가능
    - 너무 없으면 과하다는 (주관적인) 생각 / @Requestparam 은 명확하게 요청 파리미터에서 데이터를 읽는 다는 것을 알 수 있다
  - /request-param-required
    - required로 필수값 설정
    - /request-param?username=
      - 빈문자도 가능 : null 과 "" 의 차이
  - /request-param-default
    - defaultValue 설정
    - 기본값이 있는경우, required 는 의미가 없음
    - "" 의 경우에도 defaultValue 로 설정됨
  - /request-param-map
    - paramMap 형태로도 조회 가능
  - @ModelAttribute 형태(객체로 바로 받기)
    - [HelloData](./servlet/src/main/java/hello/servlet/basic/HelloData.java)
    - /model-attribute-v1
      - 스프링MVC는 @ModelAttribute 가 있으면 다음을 실행한다.
        - HelloData 객체를 생성한다.
        - 요청 파라미터의 이름으로 HelloData 객체의 프로퍼티를 찾는다. 그리고 해당 프로퍼티의 setter를 호출해서 파라미터의 값을 입력(바인딩) 한다.
        - (예) 파라미터 이름이 username 이면 setUsername() 메서드를 찾아서 호출하면서 값을 입력한다.
      - (참고) 프로퍼티
        - 객체에 getUsername() , setUsername() 메서드가 있으면, 이 객체는 username 이라는 프로퍼티를 가지고 있다.
      - (참고) 바인딩 오류
        - age=abc 처럼 숫자가 들어가야 할 곳에 문자를 넣으면 BindException 이 발생한다. 이런 바인딩 오류를 처리하는 방법은 **검증 부분**(추후 다룰예정)에서 다룬다.
    - /model-attribute-v2
      - @ModelAttribute 생략가능
      - 생략시, String , int , Integer 같은 단순 타입 = @RequestParam
      - 나머지 = @ModelAttribute (argument resolver 로 지정해둔 타입 외)

## Http 요청 파라미터 - 단순 텍스트

- HTTP message body에 데이터를 직접 담아서 요청
  - HTTP API에서 주로 사용, JSON, XML, TEXT
  - 데이터 형식은 주로 JSON 사용
  - POST, PUT, PATCH
  - Body 를 통해 데이터가 직접 데이터가 넘어오는 경우는 `@RequestParam` , `@ModelAttribute` 를 사용할 수 없다.

- [RequestBodyStringController](./springmvc/src/main/java/hello/springmvc/basic/request/RequestBodyStringController.java)
  - /request-body-string-v1
    - HTTP 메시지 바디의 데이터를 InputStream 을 사용해서 직접 읽음
    - 인코딩방식 설정 후 출력
  - /request-body-string-v2
    - 스프링 MVC는 다음 파라미터를 지원한다.
      - InputStream(Reader): HTTP 요청 메시지 바디의 내용을 직접 조회
      - OutputStream(Writer): HTTP 응답 메시지의 바디에 직접 결과 출력
  - /request-body-string-v3
    - `HttpEntity` : HTTP header, body 정보를 편리하게 조회
    - `HttpEntity` 는 응답에도 사용 가능
    - `HttpEntity`의 상속객체
      - `RequestEntity`
        - HttpMethod, url 정보가 추가, 요청에서 사용
      - `ResponseEntity`
        - HTTP 상태 코드 설정 가능, 응답에서 사용
    - 내부적으로 HttpMessageConverter 사용 -> StringHttpMessageConverter 적용
  - /request-body-string-v4
    - @RequestBody 를 사용하면 HTTP 메시지 바디 정보를 편리하게 조회할 수 있다.
      - 참고로 헤더 정보가 필요하다면 HttpEntity 를 사용하거나 @RequestHeader 를 사용하면 된다.
    - @ResponseBody 를 사용하면 응답 결과를 HTTP 메시지 바디에 직접 담아서 전달할 수 있다.
      - 물론 이 경우에도 view를 사용하지 않는다.