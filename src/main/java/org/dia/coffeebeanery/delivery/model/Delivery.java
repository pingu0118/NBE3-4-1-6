package org.dia.coffeebeanery.delivery.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer deliveryId; //배송 ID
    
    private Double deliveryNumber; //운송장 번호
    
    @Column(length = 30)
    private String deliveryCompany; //택배사
}
