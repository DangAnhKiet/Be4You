package com.example.beforyou.model.reponse;

import lombok.Data;

import java.util.List;

@Data
public class ProductPagingResponse {
    List<ProductInfoResponse> productList;
    PaginationResponse pagination;
}
