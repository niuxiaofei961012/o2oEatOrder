package com.niuxiaofei.controller;

import com.niuxiaofei.pojo.ProductCategory;
import com.niuxiaofei.pojo.ProductInfo;
import com.niuxiaofei.service.ProductService;
import com.niuxiaofei.vo.BuyerProductInfoVO;
import com.niuxiaofei.vo.CodeMsg;
import com.niuxiaofei.vo.FoodVO;
import com.niuxiaofei.vo.ResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@Api(tags = "买家操作接口")
@RequestMapping("buyer/product")
public class ProductController {
    @Resource
    private ProductService productService;

    @ApiOperation(value = "列表接口")
    @GetMapping("list")
    public ResponseVO<BuyerProductInfoVO> list() {
        //查询所有上架的商品
        List<ProductInfo> productInfoList = productService.findAllByProductStatus(0);
        //查询所有类别
        List<ProductCategory> productCategoryList = productService.findAll();
        //查询上架商品中的所有类型
        List<Integer> categoryList = productInfoList.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList());
        //构造数据
        //返回的对象中的数据----集合----
        List<BuyerProductInfoVO> buyerProductInfoVOList = new ArrayList<>();
        //循环所有类别
        for (ProductCategory productCategory : productCategoryList) {
            //定义展示的商品对象
            BuyerProductInfoVO buyerProductInfoVO = new BuyerProductInfoVO();
            buyerProductInfoVO.setName(productCategory.getCategoryName());
            buyerProductInfoVO.setType(productCategory.getCategoryType());
            //定义foodVO集合对象
            List<FoodVO> foodVOList = new ArrayList<>();
            //循环上架的商品
            for (ProductInfo productInfo: productInfoList ) {
                //如果商品中的类型和循环数据库中的类型一样就将信息商品信息放入FoodVO
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    //定义商品中的食品对象
                    FoodVO foodVO = new FoodVO();
                    BeanUtils.copyProperties(productInfo,foodVO);
                    foodVOList.add(foodVO);
                }
            }
            buyerProductInfoVO.setFoods(foodVOList);
            buyerProductInfoVOList.add(buyerProductInfoVO);
        }
        ResponseVO responseVO = new ResponseVO<>();
        responseVO.setCode(CodeMsg.SUCCESS.getCode());
        responseVO.setMsg(CodeMsg.SUCCESS.getMsg());
        responseVO.setData(buyerProductInfoVOList);


       /* //定义返回http页面结果集
        ResponseVO<BuyerProductInfoVO> responseVO = new ResponseVO<>();

        //先查询上架状态的餐品
        List<ProductInfo> productInfoList = productService.findAllByProductStatus(0);

        List<ResponseVO<BuyerProductInfoVO>> responseVOList = new ArrayList<>();
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
                //定义结果集中的BuyerProductInfoVO对象
                List<BuyerProductInfoVO> buyerProductInfoVOList = new ArrayList<>();
                BuyerProductInfoVO buyerProductInfoVO = new BuyerProductInfoVO();
                buyerProductInfoVO.setType(productCategory.getCategoryType());
                buyerProductInfoVO.setName(productCategory.getCategoryName());
                buyerProductInfoVO.setFoods(foodVOList);
                buyerProductInfoVOList.add(buyerProductInfoVO);
                responseVO.setMsg(CodeMsg.SUCCESS.getMsg());
                responseVO.setCode(CodeMsg.SUCCESS.getCode());
                responseVO.setData(buyerProductInfoVO);
            }
        }*/


        return responseVO;
    }
}
