# HttpResponse

## HttpServletResponse 역할

- http응답코드 생성
- 헤더 생성
- 바디 생성
- 편의기능
  - Content-Type, 쿠기, Redirect
- [실습 코드 디렉토리](./servlet/src/main/java/hello/servlet/basic/response)

## 기본 사용법 : 소스코드

- [실습코드 : Header Response](./servlet/src/main/java/hello/servlet/basic/response/ResponseHeaderServlet.java)
- http 헤더, 바디, 편의기능(쿠키, 리다이렉트, Content)
  
## 응답데이터 : 단순텍스트, html

- http 데이터 응답은 크게 3가지
  - 단순 텍스트
  - html응답
  - html api : message json
- [html response 실습코드 : ResponseData](./servlet/src/main/java/hello/servlet/basic/response/ResponseHtmlServlet.java)
- [api json response 실습코드 : ResponseData](./servlet/src/main/java/hello/servlet/basic/response/ResponseJsonServlet.java)
  - content-type 을 application/json 을 지정해야 한다
  - Jackson 라이브러리가 제공하는 objectMapper.writeValueAsString() 를 사용하면 객체를 JSON 문자로 변경할 수 있다

