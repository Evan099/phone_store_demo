package com.southwind.phone_store.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;

@Data
@Entity
public class OrderMaster {

    @Id
    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private Integer phoneId;
    private String phoneName;
    private Integer phoneQuantity;
    private String phoneIcon;
    private Integer specsId;
    private String specsName;
    private String specsPrice;
    private BigDecimal orderAmount;
    private Integer payStatus;
    private Date createTime;
    private Date updateTime;

}
