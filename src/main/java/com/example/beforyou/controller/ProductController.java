package com.example.beforyou.controller;

import com.example.beforyou.model.reponse.BasicResponse;
import com.example.beforyou.model.reponse.ProductInfoResponse;
import com.example.beforyou.model.reponse.ProductPagingResponse;
import com.example.beforyou.model.request.ProductInfoRequest;
import com.example.beforyou.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "products")
@Log4j2
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "")
    public BasicResponse createProduct(@RequestBody ProductInfoRequest request) {
        log.info("Start createProduct");
        return productService.addProduct(request);
    }

    @PutMapping(value = "/{code}")
    public BasicResponse updateProduct(@PathVariable String code, @RequestBody ProductInfoRequest request) {
        log.info("Start updateProduct");
        request.setCode(code);
        return productService.updateProduct(request);
    }

    @DeleteMapping(value = "/{code}")
    public BasicResponse deleteProduct(@PathVariable String code) {
        log.info("Start deleteProduct");
        return productService.deleteProduct(code);
    }

    @GetMapping(value = "/{code}")
    public ProductInfoResponse getProduct(@PathVariable String code) {
        log.info("Start getProduct");
        return productService.getProduct(code);
    }

    @GetMapping(value = "/{pageNum}/{pageSize}")
    public ProductPagingResponse getProducts(@PathVariable int pageNum, @PathVariable int pageSize) {
        log.info("Start getProducts");
        return productService.getProducts(pageNum, pageSize);
    }

}


