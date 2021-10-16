# mvc 패턴 적용하기

## mvc 패턴

![mvc](./img/mvc2.png)

- Model : 뷰에 출력할 데이터를 담아둔다
- View : 모델에 담겨있는 데이터를 활용하여 화면을 그린다.
- Controller : http 요청을 받아서 파라미터 검증 및 비즈니스 로직 실행하고 뷰에 전달할 결과를 조회하여 모델에 담는다
  - 일반적으로 비즈니스 로직은 Service 에 작성한다.

## mvc 패턴 적용

### 회원가입 폼

- [MvcMemberFormServlet](./servlet/src/main/java/hello/servlet/web/servletmvc/MvcMemberFormServlet.java)
- /WEB-INF
  - 컨트롤러에서만 호출할 수 있음(외부에서 호출 불가능)
  - url/WEB-INF/views/new-form.jsp 와같은 형태로 직접 접근 불가능
- dispatcher.forward()
  - 다른 서블릿이나 jsp로 이동
  - 서버내부에서 호출됨

> redirect vs forward
> 리다이렉트는 클라이언트에 응답이 갔다가 다시 요청
> 포워드는 서버 내부적으로 호출되어 사용자가 인식하지 못함

- [new-form.jsp](./servlet/src/main/webapp/WEB-INF/views/new-form.jsp)
- 상대경로로 save 호출함

### 회원 저장

- 앞의 jsp 로 작성한 코드와 비슷한 형태임
  - jsp 부분 문법 참조(간편하게 사용할 수 있음)
- [MvcMemberSaveServlet](./servlet/src/main/java/hello/servlet/web/servletmvc/MvcMemberSaveServlet.java)
- [save.jsp](./servlet/src/main/webapp/WEB-INF/views/save-result.jsp)

### 회원 리스트

- 앞의 jsp 로 작성한 코드와 비슷한 형태임
  - tag 활용을 위해서 다음과 같이 선언하고 사용할 수 있음
  
  ```jsp
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <c:forEach var="item" items="${members}">
  <!-- contents -->
  </c:forEach>
  ```

- [MvcMemberListServlet](./servlet/src/main/java/hello/servlet/web/servletmvc/MvcMemberListServlet.java)
- [members.jsp](./servlet/src/main/webapp/WEB-INF/views/members.jsp)
