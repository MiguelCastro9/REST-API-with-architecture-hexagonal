package com.api.domain.dto;

import com.api.infrastructure.persistence.ProductEntity;

/**
 *
 * @author Miguel Castro
 */
public class ProductResponse {

    private Long id;

    private String name;

    private Double price;

    private Integer amount;

    public ProductResponse() {
    }

    public ProductResponse(Long id, String name, Double price, Integer amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public static ProductResponse convertEntityForDto(ProductEntity productEntity) {
        return new ProductResponse(productEntity.getId(), productEntity.getName(),
                productEntity.getPrice(), productEntity.getAmount());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ProductResponse{" + "id=" + id + ", name=" + name + ", price=" + price + ", amount=" + amount + '}';
    }
}
