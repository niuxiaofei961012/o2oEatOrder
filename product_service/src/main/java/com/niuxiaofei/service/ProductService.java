package com.niuxiaofei.service;

import com.niuxiaofei.pojo.ProductCategory;
import com.niuxiaofei.pojo.ProductInfo;

import java.util.List;

public interface ProductService {

    List<ProductInfo> findAllByProductStatus(Integer productStatus);

    List<ProductCategory> findAll();
}
