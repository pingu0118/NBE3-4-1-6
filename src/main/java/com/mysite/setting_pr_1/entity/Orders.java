package com.mysite.setting_pr_1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private String customerEmail;
    private int totalPrice;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    // OrderDetail과 1:N 관계 설정
    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.orderStatus = OrderStatus.PENDING;


    }
}
