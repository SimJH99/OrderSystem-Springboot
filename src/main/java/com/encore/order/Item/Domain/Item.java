package com.encore.order.Item.Domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Item {
    //PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "item_id")
    private Long id;

    //상품 이름
    @Column(nullable = false)
    private String name;
    
    //가격
    @Column(nullable = false)
    private int price;
    
    //상품 재고 갯수
    @Column(nullable = false)
    private int stockQuantity;
    
    //상품 이미지
    private String imagePath;

    //생성 시간
    @CreationTimestamp
    private LocalDateTime createdTime;
    
    //수정 시간
    @UpdateTimestamp
    private LocalDateTime updatedTime;

    public void orderedQuantity (int stockQuantity){
        this.stockQuantity = this.stockQuantity - stockQuantity;
    }

    public void cancledQuantity (int stockQuantity){
        this.stockQuantity = this.stockQuantity + stockQuantity;
    }
}