package com.niuxiaofei.dao;

import com.niuxiaofei.pojo.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {
    List<ProductInfo> findAllByProductStatus(Integer productStatus);
}
