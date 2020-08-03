package com.southwind.phone_store.service.Impl;

import com.southwind.phone_store.dto.OrderDTO;
import com.southwind.phone_store.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderServiceImplTest {

    @Autowired
    private OrderService orderService;

    @Test
    void create(){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("张三");
        orderDTO.setBuyerPhone("13788889999");
        orderDTO.setBuyerAddress("四川省");
        orderDTO.setSpecsId(1);
        orderDTO.setPhoneQuantity(1);

        OrderDTO result = orderService.creat(orderDTO);
        System.out.println(result);


    }

}