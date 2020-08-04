package com.southwind.phone_store.service;

import com.southwind.phone_store.dto.OrderDTO;
import com.southwind.phone_store.vo.OrderDetailVO;

public interface OrderService {
    public OrderDTO creat(OrderDTO orderDTO);

    public OrderDetailVO findOrderDetailVOByOrderId(String orderId);

    public String pay(String orderId);
}
