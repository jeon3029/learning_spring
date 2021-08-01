# HttpServletRequest

## HttpServlet 기능

- 요청 메세지

```text
  POST /save HTTP/1.1
  Host: localhost:8080
  Content-Type: application/x-www-form-urlencoded
  username=kim&age=20
```

- Start Line
  - HttpMethod
  - Url
  - 쿼리스트링
  - 스키마, 프로토콜
- 헤더
  - 헤더조회
- 바디
  - form 파리미터 조회
  - message body 조회
- 임시저장소 기능
  - request.setAttribute(name,value)
  - request.getAttribute(name)
- 세션 고나리 기능
  - request.getSession(create:true)

> 중요
> http스펙이 제공하는 요청, 응답 자체를 이해해야 됨

## HttpServletRequest 사용법

- 헤더 정보를 확인하는 법 다음 소스코드 참고
- [headerServlet](./servlet/build/classes/java/main/hello/servlet/basic/request/RequestHeaderServlet.class)
