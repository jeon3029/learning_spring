# 요청매핑

## 코드로 보는 요청매핑

- [MappingController](./springmvc/src/main/java/hello/springmvc/basic/requestmapping/MappingController.java)
- 기본 설정
  - @RestController
    - @Controller 는 반환 값이 String 이면 뷰 이름으로 인식
    - @RestController 는 반환 값으로 뷰를 찾는 것이 아니라, HTTP 메시지 바디에 바로 입력
  - @RequestMapping("/hello-basic")
    - 대부분의 속성을 배열[] 로 제공하므로 다중 설정이 가능하다. `{"/hello-basic", "/hello-go"}`
  - @RequestMapping
    - method 속성으로 HTTP 메서드를 지정하지 않으면 HTTP 메서드와 무관하게 호출된다.
    - GET, HEAD, POST, PUT, PATCH, DELETE 모두 허용 
  - 참고
    - URL 요청: /hello-basic , /hello-basic/
    - 위 두가지는 다르지만, 스프링에서는 같은 요청으로 매핑됨
- mapping-get-v1
  - method를 설정해두면 post등 다른 방식은 허용하지 않는다
- mapping-get-v2
  - 만들어진 어노테이션 활용
- pathvariable(경로변수)
  - 최근 HTTP API는 다음과 같이 리소스 경로에 식별자를 넣는 스타일을 선호
  - (예) `/users/1`
  - @PathVariable 의 이름과 파라미터 이름이 같으면 생략할 수 있다.
- pathvariavla(다중)
  - 다중으로 사용 가능
- 특정 파라미터 조건 매핑
  - `params = "mode=debug"`
  - mode가 없으면 호출이 안됨
  - !=, {여러개 조건..} 등 사용가능
- 특정 헤더로 추가 매핑
  - 헤더가 없으면 호출이 안됨
  - 파라미터와 마찬가지로 헤더가 없을때 등 커스터마이징 가능
- Content-Type 헤더 기반 추가 매핑 Media Type : `consume`
  - Content-Type 헤더를 기반으로 미디어 타입으로 매핑
  - 만약 맞지 않으면 HTTP 415 상태코드(Unsupported Media Type)을 반환
- 미디어 타입 조건 매핑 - HTTP 요청 Accept : `produce`
  - HTTP 요청의 Accept 헤더를 기반으로 미디어 타입으로 매핑
  - 만약 맞지 않으면 HTTP 406 상태코드(Not Acceptable)을 반환

## 요청매핑 - API 예시

- [MappingClassController](./springmvc/src/main/java/hello/springmvc/basic/requestmapping/MappingClassController.java)
