package com.niuxiaofei.service;

import com.niuxiaofei.dao.ProductCategoryRepository;
import com.niuxiaofei.dao.ProductInfoRepository;
import com.niuxiaofei.pojo.ProductCategory;
import com.niuxiaofei.pojo.ProductInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{
    @Resource
    private ProductInfoRepository productInfoRepository;

    @Resource
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductInfo> findAllByProductStatus( Integer productStatus) {
        return productInfoRepository.findAllByProductStatus(productStatus);
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryRepository.findAll();
    }
}
