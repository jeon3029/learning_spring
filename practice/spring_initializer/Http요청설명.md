# Http 요청 데이터

## 개요

- 데이터를 전송하는 방법

### GET

- 쿼리 파라미터
- /url?username=hello&age=20

### POST

- content-type: application x-www-form-urlencoded
- 메시지 바디에 쿼리 파리미터 형식으로 전달 username=hello&age=20

### Http message body

- HTTP API에서 주로 사용, JSON, XML, TEXT

## GET 방식 쿼리 파라미터

### 쿼리 예시

- http://localhost:8080/request-param?username=hello&age=20
  - request.getParameter() 로 정보 꺼내서 씀
- http://localhost:8080/request-param?username=hello&age=20&username=hello2
  - 중복일 때는 request.getParameterValues() 를 사용

## POST 방식 쿼리 파라미터

### 특징

- content-type: application/x-www-form-urlencoded
메시지 바디에 쿼리 파리미터 형식으로 데이터를 전달한다. 
- username=hello&age=20

### 예제

1. 다음과 같이 x-www-form-urlencoded 형식으로 보내는 방법

```html
<form action="/request-param" method="post">
    username: <input type="text" name="username" /> age: <input type="text" name="age" /> <button type="submit">전송</button>
</form>
```

- src/main/webapp/basic/hello-form.html 생성
- 다음 url로 실행
  - <http://localhost:8080/basic/hello-form.html>
  - **요청 URL**: <http://localhost:8080/request-param>
  - **content-type**: application/x-www-form-urlencoded - **message** body: username=hello&age=20

2. postman으로 실행
![img](./img/postman1.png)
   - 데이터가 전달되는 과정은 똑같음

### 참고

- **GET URL 쿼리 파라미터** 형식으로 클라이언트에서 서버로 데이터를 전달할 때는 HTTP 메시지 바디를 사용하지 않기 때문에 content-type이 없다.
- **POST HTML Form** 형식으로 데이터를 전달하면 HTTP 메시지 바디에 해당 데이터를 포함해서 보내기 때문에 바디에 포함된 데이터가 어떤 형식인지 content-type을 꼭 지정해야 한다. 이렇게 폼으로 데이터를 전송하는 형식을 *application/x-www-form-urlencoded* 라 한다.

