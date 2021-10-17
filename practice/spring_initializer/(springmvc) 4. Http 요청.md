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