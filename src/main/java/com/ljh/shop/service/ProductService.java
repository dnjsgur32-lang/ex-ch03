package com.ljh.shop.service;

import com.ljh.shop.domain.Product;
import com.ljh.shop.mapper.ProductMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {
    private final ProductMapper productMapper;

    public ProductService(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public List<Product> getList() {
        return productMapper.findAll();
    }

    public Product getOne(Long id) {
        return productMapper.findById(id);
    }

    @Transactional
    public void create(Product product) {
        productMapper.insert(product);
    }

    @Transactional
    public void update(Product product) {
        productMapper.update(product);
    }

    @Transactional
    public void delete(Long id) {
        productMapper.deleteById(id);
    }

    public Object findAll() {
        return productMapper.findAll();
    }
}
