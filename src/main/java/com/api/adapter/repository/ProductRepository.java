package com.api.adapter.repository;

import com.api.infrastructure.persistence.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Miguel Castro
 */
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
