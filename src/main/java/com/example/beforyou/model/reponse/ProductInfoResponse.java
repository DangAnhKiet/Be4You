package com.example.beforyou.model.reponse;

import com.example.beforyou.model.entity.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductInfoResponse {
    private int id;
    private String code;
    private String name;
    private String category;
    private String brand;
    private String type;
    private String description;

    public ProductInfoResponse(Product product) {
        this.id = product.getId();
        this.code = product.getCode();
        this.name = product.getName();
        this.category = product.getCategory();
        this.brand = product.getBrand();
        this.type = product.getType();
        this.description = product.getDescription();
    }
}
