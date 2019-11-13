package com.niuxiaofei.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FoodVO {

    private String id;
    private String name;
    private BigDecimal price;
    private String description;
    private String icon;
}
