package com.example.beforyou.service;

import com.example.beforyou.model.reponse.BasicResponse;
import com.example.beforyou.model.reponse.ProductInfoResponse;
import com.example.beforyou.model.reponse.ProductPagingResponse;
import com.example.beforyou.model.request.ProductInfoRequest;

import java.util.List;

public interface ProductService {
    BasicResponse addProduct(ProductInfoRequest request);

    BasicResponse updateProduct(ProductInfoRequest request);

    BasicResponse deleteProduct(String code);

    ProductInfoResponse getProduct(String code);

    ProductPagingResponse getProducts(int pageNum, int pageSize);
}
