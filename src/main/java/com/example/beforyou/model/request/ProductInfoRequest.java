package com.example.beforyou.model.request;

import lombok.Data;

@Data
public class ProductInfoRequest {
    private String code;
    private String name;
    private String category;
    private String brand;
    private String type;
    private String description;
}
