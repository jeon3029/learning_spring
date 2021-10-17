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
  - 속성
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
  - request-param-v1
  - Test :
    - GET : <http://localhost:8080/request-param-v1?username=hello&age=20>
    - POST Form : [hello-form.html](./servlet/src/main/webapp/basic/hello-form.html)
