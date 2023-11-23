package com.api.application;

import com.api.adapter.repository.ProductRepository;
import com.api.infrastructure.persistence.ProductEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Miguel Castro
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductEntity> list() {
        return productRepository.findAll();
    }

    public ProductEntity find(Long id) {
        return productRepository.getReferenceById(id);
    }
}
