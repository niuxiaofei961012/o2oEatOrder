package com.niuxiaofei.util;


import com.niuxiaofei.pojo.ProductInfo;
import com.niuxiaofei.vo.FoodVO;

public class DataTranferTool {



    public static FoodVO transferProductInfo(ProductInfo productInfo) {
        FoodVO foodVO = new FoodVO();
        foodVO.setId(productInfo.getProductId());
        foodVO.setDescription(productInfo.getProductDescription());
        foodVO.setIcon(productInfo.getProductIcon());
        foodVO.setName(productInfo.getProductName());
        foodVO.setPrice(productInfo.getProductPrice());
        return foodVO;
    }

}
