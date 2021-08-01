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
- [headerServlet](./servlet/src/main/java/hello/servlet/basic/request/RequestHeaderServlet.java)
- 실행 결과
```text
--- REQUEST-LINE - start ---
request.getMethod() = GET
request.getProtocal() = HTTP/1.1
request.getScheme() = http
request.getRequestURL() = http://localhost:8080/request-header
request.getRequestURI() = /request-header
request.getQueryString() = username=kim
request.isSecure() = false
--- REQUEST-LINE - end ---

--- Headers - start ---
host:localhost:8080
connection:keep-alive
cache-control:max-age=0
sec-ch-ua:"Chromium";v="92", " Not A;Brand";v="99", "Google Chrome";v="92"
sec-ch-ua-mobile:?0
upgrade-insecure-requests:1
user-agent:Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.107 Safari/537.36
accept:text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
sec-fetch-site:none
sec-fetch-mode:navigate
sec-fetch-user:?1
sec-fetch-dest:document
accept-encoding:gzip, deflate, br
accept-language:ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7,es;q=0.6,de;q=0.5
cookie:Idea-5b2f8308=6fe0a5e1-e4a5-499a-992d-a210fe0ef8f2
--- Headers - end ---

--- Header 편의 조회 start ---
[Host 편의 조회]
request.getServerName() = localhost
request.getServerPort() = 8080

[Accept-Language 편의 조회]
locale = ko_KR
locale = ko
locale = en_US
locale = en
locale = es
locale = de
request.getLocale() = ko_KR

[cookie 편의 조회]
Idea-5b2f8308: 6fe0a5e1-e4a5-499a-992d-a210fe0ef8f2

[Content 편의 조회]
request.getContentType() = null
request.getContentLength() = -1
request.getCharacterEncoding() = UTF-8
--- Header 편의 조회 end ---

--- 기타 조회 start ---
[Remote 정보]
request.getRemoteHost() = 0:0:0:0:0:0:0:1
request.getRemoteAddr() = 0:0:0:0:0:0:0:1
request.getRemotePort() = 55800

[Local 정보]
request.getLocalName() = localhost
request.getLocalAddr() = 0:0:0:0:0:0:0:1
request.getLocalPort() = 8080
--- 기타 조회 end ---
```