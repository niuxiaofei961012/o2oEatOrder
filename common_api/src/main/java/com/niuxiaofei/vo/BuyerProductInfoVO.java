package com.niuxiaofei.vo;

import lombok.Data;

import java.util.List;

@Data
public class BuyerProductInfoVO {

    private String name;
    private Integer type;
    private List<FoodVO> foods;

}
