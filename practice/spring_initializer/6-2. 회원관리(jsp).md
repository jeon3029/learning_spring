# jsp로 회원관리 어플리케이션 만들기

서블릿을 활용하면 어떤 단점이 있는지 알아보았고, html 소스에 바로 java코드를 삽입할 수 있는 템플릿 엔진인 jsp 를 알아보자

## 편의를 위해 index.html 수정

- [index.html](./servlet/src/main/webapp/index.html)
- 앞으로 사용할 링크 설정

## jsp 사용하기 위해 라이브러리 추가

- build.gradle -> dependences{}
```
//JSP 추가 시작
implementation 'org.apache.tomcat.embed:tomcat-embed-jasper' implementation 'javax.servlet:jstl'
//JSP 추가 끝
```

## 회원가입 작성

- 회원등록
  - [new-form](./servlet/src/main/webapp/jsp/members/new-form.jsp)
- 회원 저장
  - [save](./servlet/src/main/webapp/jsp/members/save.jsp)
- 회원 리스트
  - [members](./servlet/src/main/webapp/jsp/members.jsp)

## 특징

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
```

- 첫번째 줄에는 항상 다음과 같이 써서 jsp 파일임을 알린다.

```jsp
<%
//your code
%>
```

- 다음과 같이 java code 입력 가능

```jsp
<%= member.getID() %>
```

- 다음과 같이 java 변수 출력가능

## jsp의 한계

- 서블릿으로 작성하는 것보다는 나아졌지만, 비즈니스 로직이 한 파일에 집중되어, 파일이 커지게 되면 상당히 힘들어지게 된다.
- MVC 패턴이 등장하게 된다
  - 비즈니스 로직은 다른 곳에서 처리하고, jsp는 그리는(html)일에 집중하도록.