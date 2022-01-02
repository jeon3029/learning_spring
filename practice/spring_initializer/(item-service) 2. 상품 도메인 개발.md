# 개발 진행

## 도메인 개발

- [Item](./item-service/src/main/java/hello/itemservice/domain/item/Item.java)
- [ItemRepository](./item-service/src/main/java/hello/itemservice/domain/item/ItemRepository.java)
- [ItemRepositoryTest](./item-service/src/test/java/hello/itemservice/domain/item/ItemRepositoryTest.java)

## 상품서비스 HTML

- HTML을 편리하게 개발하기 위해 부트스트랩 사용
  - 부트스트랩 공식 사이트: <https://getbootstrap.com>
- 부트스트랩을 다운로드 받고 압축을 풀자.
5.0/getting-started/download/>
  - Compiled CSS and JS 항목을 다운로드하자.
- 압축을 출고 bootstrap.min.css 를 복사해서 다음 폴더에 추가하자
  - resources/static/css/bootstrap.min.css

- [item](./item-service/src/main/resources/static/html/item.html)
- [items](./item-service/src/main/resources/static/html/items.html)
- [addForm](./item-service/src/main/resources/static/html/addForm.html)
- [editForm](./item-service/src/main/resources/static/html/editForm.html)

- 여기서는 웹 퍼블리셔가 있다는 전제하에 구체적인 문법 등은 다루지 않는다.(이해만 하면 됨)

> 정적 리소스가 공개되는 /resources/static 폴더에 HTML을 넣어두면, 실제 서비스에서도 공개된다.
> 서비스를 운영한다면 지금처럼 공개할 필요없는 HTML을 두는 것은 주의!
