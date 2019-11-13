package com.niuxiaofei.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;


@Data
@Table(name = "product_info")
@Entity
public class ProductInfo {

    @Id
    @GeneratedValue
    private String productId;

    /** 名字. */
    private String productName;

    /** 单价. */
    private BigDecimal productPrice;

    /** 库存. */
    private Integer productStock;

    /** 描述. */
    private String productDescription;

    /** 小图. */
    private String productIcon;

    /** 状态, 0正常1下架. */
    private Integer productStatus = 0;

    /** 类目编号. */
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;


    /*public static void main(String[] args) {
        // add subtract
        BigDecimal a = new BigDecimal(5);
        BigDecimal b = new BigDecimal("1.2");
        System.out.println(a.add(b));
        System.out.println(a.subtract(b));
        System.out.println(a.multiply(b));
        System.out.println(a.divide(b,2,BigDecimal.ROUND_HALF_UP));

    }*/
}
