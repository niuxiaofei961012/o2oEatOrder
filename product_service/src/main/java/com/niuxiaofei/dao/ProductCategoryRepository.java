package com.niuxiaofei.dao;

import com.niuxiaofei.pojo.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
    @Override
    List<ProductCategory> findAll();
}
