package com.niuxiaofei.service;

import com.niuxiaofei.dao.ProductCategoryRepository;
import com.niuxiaofei.dao.ProductInfoRepository;
import com.niuxiaofei.pojo.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
    @Resource
    private ProductCategoryRepository productCategoryRepository;

    @Resource
    private ProductInfoRepository productInfoRepository;


    @Test
    public void findAllByCategoryTypeAndProductStatus() {

    }

    @Test
    public void findAll() {
        List<ProductCategory> all = productCategoryRepository.findAll();
        System.out.println(all);
    }
}