package com.example.beforyou.service;

import com.example.beforyou.model.entity.Product;
import com.example.beforyou.model.reponse.BasicResponse;
import com.example.beforyou.model.reponse.PaginationResponse;
import com.example.beforyou.model.reponse.ProductInfoResponse;
import com.example.beforyou.model.reponse.ProductPagingResponse;
import com.example.beforyou.model.request.ProductInfoRequest;
import com.example.beforyou.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public BasicResponse addProduct(ProductInfoRequest request) {
        Product product = new Product(request);

        try {
            productRepository.save(product);
        } catch (Exception e) {
            log.error("Error addProduct {}", e.getMessage());
            return new BasicResponse(false);
        }

        return new BasicResponse(true);
    }

    @Override
    public BasicResponse updateProduct(ProductInfoRequest request) {
        Product product = productRepository.findByCode(request.getCode());
        if (product != null) {
            product.setName(request.getName());
            product.setBrand(request.getBrand());
            product.setCategory(request.getCategory());
            product.setType(request.getType());
            product.setDescription(request.getDescription());
            productRepository.save(product);
            return new BasicResponse(true);
        } else {
            return new BasicResponse(false);
        }
    }

    @Override
    public BasicResponse deleteProduct(String code) {
        Product product = productRepository.findByCode(code);
        if (product != null) {
            product.setStatus("inactive");
            productRepository.save(product);
            return new BasicResponse(true);
        } else {
            return new BasicResponse(false);
        }
    }

    @Override
    public ProductInfoResponse getProduct(String code) {
        Product product = productRepository.findByCode(code);
        return new ProductInfoResponse(product);
    }

    @Override
    public ProductPagingResponse getProducts(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, Sort.by("id").descending());
        List<Product> list = productRepository.findAllBy(pageable);
        List<ProductInfoResponse> responses = new ArrayList<>();
        for (Product product : list) {
            responses.add(new ProductInfoResponse(product));
        }

        long totalProducts = productRepository.count();

        ProductPagingResponse pagingResponse = new ProductPagingResponse();
        pagingResponse.setProductList(responses);
        PaginationResponse paginationResponse = new PaginationResponse();
        paginationResponse.setPage(pageNum);
        paginationResponse.setSize(pageSize);
        paginationResponse.setTotal(totalProducts / pageSize);
        pagingResponse.setPagination(paginationResponse);
        return pagingResponse;
    }
}
