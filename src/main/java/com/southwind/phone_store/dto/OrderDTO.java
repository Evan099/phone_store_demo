package com.southwind.phone_store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class OrderDTO {
    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private Integer specsId;
    private Integer phoneQuantity;
}
