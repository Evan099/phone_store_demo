package com.southwind.phone_store.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;


@Data
@Entity
public class PhoneInfo {
    @Id//主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增方式=自增
    private Integer phoneId;
    private String phoneName;
    private BigDecimal phonePrice;
    private String phoneDescription;
    private Integer phoneStock;
    private String phoneIcon;
    private Integer categoryType;
    private String phoneTag;
    private Date createTime;
    private Date updateTime;

}
