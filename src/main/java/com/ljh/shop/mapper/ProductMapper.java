package com.ljh.shop.mapper;

import com.ljh.shop.domain.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<Product> findAll();
    Product findById(@Param("id") Long id);
    int insert(Product p);
    int update(Product p);
    int deleteById(@Param("id") Long id);
}
