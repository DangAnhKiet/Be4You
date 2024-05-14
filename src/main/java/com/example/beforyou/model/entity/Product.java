package com.example.beforyou.model.entity;

import com.example.beforyou.model.request.ProductInfoRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "category")
    private String category;
    @Column(name = "brand")
    private String brand;
    @Column(name = "type")
    private String type;
    @Column(name = "description")
    private String description;
    @Column(name = "status")
    private String status;

    public Product(ProductInfoRequest request) {
        this.code = request.getCode();
        this.name = request.getName();
        this.category = request.getCategory();
        this.brand = request.getBrand();
        this.type = request.getType();
        this.description = request.getDescription();
        this.status = "active";
    }
}
