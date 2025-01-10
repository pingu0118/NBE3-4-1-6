package com.mysite.pr2.config;

import com.mysite.pr2.product.Product;
import com.mysite.pr2.product.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//public class DataInitializer {
//
//    @Bean
//    public CommandLineRunner initializeData(ProductRepository productRepository) {
//        return args -> {
//            // 상품 데이터 초기화
//            productRepository.save(Product.builder()
//                    .productName("커피1")
//                    .productDescription("블랙")
//                    .productPrice(1200000L)
//                    .productStock(50)
//                    .productImageURL("/images/black.jpg")
////                    .productOrigin("브라질")
//                    .build());
//
//            productRepository.save(Product.builder()
//                    .productName("커피2")
//                    .productDescription("화이트")
//                    .productPrice(1100000L)
//                    .productStock(70)
//                    .productImageURL("/images/wh.jpg")
////                    .productOrigin("콜롬비아")
//                    .build());
//
//            productRepository.save(Product.builder()
//                    .productName("커피3")
//                    .productDescription("퍼플")
//                    .productPrice(350000L)
//                    .productStock(30)
//                    .productImageURL("/images/purple.jpg")
////                    .productOrigin("에티오피아")
//                    .build());
//        };
//    }
//}
@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initializeData(ProductRepository productRepository) {
        return args -> {
            // 상품 데이터 추가
            createProductIfNotExists(productRepository, "커피1", "블랙", 1000L, 50, "/images/black.jpg");
            createProductIfNotExists(productRepository, "커피2", "화이트", 2000L, 70, "/images/wh.jpg");
            createProductIfNotExists(productRepository, "커피3", "퍼플", 3000L, 30, "/images/purple.jpg");
        };
    }

    private void createProductIfNotExists(ProductRepository productRepository, String name, String description, Long price, int stock, String imageUrl) {
        boolean exists = productRepository.existsByProductName(name); // 이름으로 존재 여부 확인
        if (!exists) {
            productRepository.save(Product.builder()
                    .productName(name)
                    .productDescription(description)
                    .productPrice(price)
                    .productStock(stock)
                    .productImageURL(imageUrl)
                    .build());
        }
    }
}


