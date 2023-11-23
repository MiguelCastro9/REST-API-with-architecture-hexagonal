package com.api.adapter.controller;

import com.api.application.ProductService;
import com.api.domain.dto.ProductResponse;
import com.api.infrastructure.persistence.ProductEntity;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Miguel Castro
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/list")
    public ResponseEntity<List<ProductResponse>> list() {

        return new ResponseEntity<List<ProductResponse>>(
                productService.list().stream().map(product
                        -> ProductResponse.convertEntityForDto(product))
                        .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ProductResponse> find(@PathVariable("id") Long id) {

        ProductEntity productEntity = productService.find(id);
        ProductResponse productResponse = ProductResponse.convertEntityForDto(productEntity);
        return new ResponseEntity<ProductResponse>(productResponse, HttpStatus.OK);
    }
}
