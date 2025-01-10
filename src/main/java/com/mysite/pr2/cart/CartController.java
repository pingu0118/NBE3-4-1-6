//package com.mysite.pr2.cart;
//
//import jakarta.servlet.http.HttpSession;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/cart")
//@RequiredArgsConstructor
//public class CartController {
//
//    @GetMapping("")
//    public String viewCart(HttpSession session) {
//        return "cart";
//    }
//
////    @GetMapping("/checkout")
////    public String checkout(HttpSession session) {
////        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
////        if (cart != null && !cart.isEmpty()) {
////            return "redirect:/payment";
////        }
////        return "redirect:/products";
////    }
//
////    @PostMapping("/checkout/success")
////    public String checkoutSuccess(HttpSession session) {
////        session.removeAttribute("cart");
////        return "redirect:/products";
////    }
//}