package com.niuxiaofei.controller;

import com.niuxiaofei.pojo.ProductCategory;
import com.niuxiaofei.pojo.ProductInfo;
import com.niuxiaofei.service.ProductService;
import com.niuxiaofei.vo.BuyerProductInfoVO;
import com.niuxiaofei.vo.CodeMsg;
import com.niuxiaofei.vo.FoodVO;
import com.niuxiaofei.vo.ResponseVO;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {
    @Resource
    private ProductService productService;

    @RequestMapping("list")
    public ResponseVO<BuyerProductInfoVO> list() {
        //定义返回http页面结果集
        ResponseVO<BuyerProductInfoVO> resultList = new ResponseVO<>();
        //定义结果集中的BuyerProductInfoVO对象
        BuyerProductInfoVO buyerProductInfoVO = new BuyerProductInfoVO();
        //先查询上架状态的餐品
        List<ProductInfo> productInfoList = productService.findAllByProductStatus(0);
        for (ProductInfo productInfo : productInfoList) {
            //查询所有类型
            List<ProductCategory> productCategoryList = productService.findAll();
            for (ProductCategory productCategory : productCategoryList) {
                //定义Food集合
                List<FoodVO> foodVOList = new ArrayList<>();
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    //定义Food对象
                    FoodVO foodVO = new FoodVO();
                    BeanUtils.copyProperties(productInfo,foodVO);
                    foodVOList.add(foodVO);
                }
                buyerProductInfoVO.setType(productCategory.getCategoryType());
                buyerProductInfoVO.setName(productCategory.getCategoryName());
                buyerProductInfoVO.setFoods(foodVOList);
            }

        }

        resultList.setCode(CodeMsg.SUCCESS.getCode());
        resultList.setMsg(CodeMsg.SUCCESS.getMsg());
        resultList.setData(buyerProductInfoVO);
        return resultList;
    }
}
