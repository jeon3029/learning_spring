# 회원관리 웹 Application By Servlet

## 요구사항

- 회원정보
  - 이름 : username
  - 나이 : age
- 기능
  - 회원 저장
  - 회원 목록 조회

## 회원 도메인 모델

- [Member](./servlet/src/main/java/hello/servlet/domain/member/Member.java)
- [MemberRepository](./servlet/src/main/java/hello/servlet/domain/member/MemberRepository.java)
  - [MemberRepositoryTest](./servlet/src/test/java/hello/servlet/domain/member/MemberRepositoryTest.java)

## 1. Servlet 으로  회원관리 어플리케이션

- 데이터 저장을 위한 폼
  - [MemberFormServlet](./servlet/src/main/java/hello/servlet/web/servlet/MemberFormServlet.java)
- 저장하기
  - [MemberSaveServlet](./servlet/src/main/java/hello/servlet/web/servlet/MemberSaveServlet.java)
- 전체 목록 테이블로 확인
  - [MemberListServlet](./servlet/src/main/java/hello/servlet/web/servlet/MemberListServlet.java)
- html 코드를 java 로 작성하는 불편함이 있음 + 가동성이 안좋음
  - html 소스가 길어지게 되면 디버깅이 거의 불가능함
  - 템플릿 엔진 사용으로 html 코드에 java 코드 삽입 가능
    - 대표적인 템플릿 엔진 : jsp, Thymeleaf
