package com.mysite.pr2.product;

import com.mysite.pr2.cart.CartItem;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    // 세션에서 장바구니를 가져오는 메서드
    @SuppressWarnings("unchecked")
    private List<CartItem> getCart(HttpSession session) {
        return (List<CartItem>) session.getAttribute("cart");
    }

    // 홈페이지(상품목록)
    @GetMapping("/")
    public String productList(Model model, HttpSession session) {
//        List<Product> productList = productService.getAllProducts();
//        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        List<ProductDTO> productList = productService.getAllProducts().stream().map(product -> {
            ProductDTO dto = new ProductDTO();
            dto.setId(product.getProductId());
            dto.setName(product.getProductName());
            dto.setDescription(product.getProductDescription());
//            dto.setOrigin(product.getProductOrigin());
            dto.setPrice(product.getProductPrice());
            dto.setStockQuantity(product.getProductStock());
            dto.setImageUrl(product.getProductImageURL());
            return dto;
        }).toList();





        List<CartItem> cart = getCart(session);
// 장바구니 총 금액계산
        long totalPrice = (cart != null) ?
                cart.stream().mapToLong(item -> item.getPrice() * item.getQuantity()).sum()
                : 0;
// view에  전달
        model.addAttribute("products", productList);
        model.addAttribute("cart", cart);
        model.addAttribute("totalPrice", totalPrice);
        return "product_list";
    }

    // 장바구니 페이지
    @GetMapping("/cart")
    public String cartPage(Model model, HttpSession session) {
        List<CartItem> cart = getCart(session);

        long totalPrice = (cart != null) ? cart.stream()
                .mapToLong(item -> item.getPrice() * item.getQuantity()).sum() : 0;

        model.addAttribute("cart", cart);
        model.addAttribute("totalPrice", totalPrice);

        return "cart"; // 장바구니 페이지 템플릿
    }

    // 장바구니에 상품 추가
    @PostMapping("/addToCart")
    public String addToCart(@RequestParam("id") Long productId,
                            @RequestParam("quantity") int quantity,
                            HttpSession session) {
//        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
          List<CartItem> cart = getCart(session);
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }
//상품 중복 확인  (같은 상품이 있는지 확인후 같은상품 있으면 수량만 증가)
        boolean itemExists = false;
        for (CartItem item : cart) {
            if (item.getProductId().equals(productId)) {
                item.setQuantity(item.getQuantity() + quantity);
                itemExists = true;
                break;
            }
        }
        if (!itemExists) {
            Product product = productService.getProduct(productId);
            cart.add(CartItem.builder()
                    .productId(productId)
                    .quantity(quantity)
                    .price(product.getProductPrice())
                    .productName(product.getProductName())
                    .imageUrl(product.getProductImageURL())  // 이미지 추가
                    .build());
        }
        return "redirect:/cart";
    }  // 상품추가후 장바구니페이지 리다이렉트 (변경필요)
//    상품추가후 장바구니로 이동할 건지 계속 상품페이지에 머물것인지 확인 필요.

    // 장바구니에서 상품 삭제
    @PostMapping("/removeFromCart")
    public String removeFromCart(@RequestParam("id") Long productId, HttpSession session) {
//        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        List<CartItem> cart = getCart(session);
        if (cart != null) {
            cart.removeIf(item -> item.getProductId().equals(productId));
        }
        return "redirect:/cart";
//        장바구니 페이지로이동
    }

    // 장바구니에서 수량 변경
    @PostMapping("/updateCart")
    public String updateCart(@RequestParam("id") Long productId,
                             @RequestParam("quantity") int quantity,
                             HttpSession session) {
        List<CartItem> cart = getCart(session);
        if (cart != null) {
            for (CartItem item : cart) {
                if (item.getProductId().equals(productId)) {
                    item.setQuantity(quantity); // 수량 업데이트
                    break;
                }
            }
        }
        return "redirect:/cart"; // 장바구니 페이지로 리다이렉트
    }

}
