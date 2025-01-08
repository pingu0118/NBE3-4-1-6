# NBE3-4-1-6
> 프로그래머스 데브코스: 팀 프로젝트 #1

## 설명
고객들에게 커피콩 상품을 판매하는 웹 사이트 입니다.  
매일 전날 오후 2시부터 오늘 오후 2시까지의 주문을 모아서 처리합니다.  
별도의 회원관리는 하지 않습니다.  

## 기술
Backend: Spring Boot  
Frontend: React  
Database: H2 Database  

## 디렉터리 구조

```
├───main
│   ├───java
│   │   └───org
│   │       └───team6
│   │           └───coffeebeanery
│   │               │   CoffeeBeaneryApplication.java
│   │               │
│   │               ├───common
│   │               │   ├───constant
│   │               │   │       OrderStatus.java
│   │               │   │
│   │               │   ├───exception
│   │               │   │       ErrorDetails.java
│   │               │   │       GlobalExceptionHandler.java
│   │               │   │       InvalidInputException.java
│   │               │   │       ResourceNotFoundException.java
│   │               │   │
│   │               │   ├───model
│   │               │   │       Address.java
│   │               │   │
│   │               │   └───validation
│   │               │           Url.java
│   │               │           UrlValidator.java
│   │               │
│   │               ├───delivery
│   │               │   ├───controller
│   │               │   │       DeliveryController.java
│   │               │   │
│   │               │   ├───model
│   │               │   │       Delivery.java
│   │               │   │
│   │               │   ├───repository
│   │               │   │       DeliveryRepository.java
│   │               │   │
│   │               │   └───service
│   │               │           DeliveryService.java
│   │               │
│   │               ├───order
│   │               │   ├───controller
│   │               │   │       BuyerOrderController.java
│   │               │   │       SellerOrderController.java
│   │               │   │
│   │               │   ├───model
│   │               │   │       Order.java
│   │               │   │       OrderDetail.java
│   │               │   │
│   │               │   ├───repository
│   │               │   │       OrderRepository.java
│   │               │   │
│   │               │   └───service
│   │               │           BuyerOrderService.java
│   │               │           SellerOrderService.java
│   │               │
│   │               └───product
│   │                   ├───controller
│   │                   │       BuyerProductController.java
│   │                   │       SellerProductController.java
│   │                   │
│   │                   ├───model
│   │                   │       Product.java
│   │                   │
│   │                   ├───repository
│   │                   │       ProductRepository.java
│   │                   │
│   │                   └───service
│   │                           BuyerProductService.java
│   │                           SellerProductService.java
│   │
│   └───resources
│       │   application.properties
│       │
│       ├───static
│       │       bootstrap.min.css
│       │       style.css
│       │
│       └───templates
│               sample.html
│
└───test
    └───java
        └───org
            └───team6
                └───coffeebeanery
                        CoffeeBeaneryApplicationTests.java
                        DataSourceTest.java
```

*(console `free /F` 입력)  
