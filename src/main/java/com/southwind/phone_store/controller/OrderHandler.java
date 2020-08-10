package com.southwind.phone_store.controller;

import com.southwind.phone_store.dto.OrderDTO;
import com.southwind.phone_store.exception.PhoneException;
import com.southwind.phone_store.form.OrderForm;
import com.southwind.phone_store.service.OrderService;
import com.southwind.phone_store.service.PhoneService;
import com.southwind.phone_store.until.ResultVOUtil;
import com.southwind.phone_store.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/order")
@Slf4j
@Api(tags = "订单模块")
public class OrderHandler {
    @Autowired
    private OrderService orderService;
    @Autowired
    private PhoneService phoneService;

    @ApiOperation("创建一个订单")
    @PostMapping("/create")
    public ResultVO create(@Valid @RequestBody OrderForm orderForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
                log.error("【创建订单】参数错误,orderFrom={}",orderForm);
                throw new PhoneException(bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getTel());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setSpecsId(orderForm.getSpecsId());
        orderDTO.setPhoneQuantity(orderForm.getQuantity());

        OrderDTO result = orderService.creat(orderDTO);

        Map<String,String> map = new HashMap<>();
        map.put("orderId",result.getOrderId());

        //减库存
        phoneService.subStock(orderForm.getSpecsId(),orderForm.getQuantity());

        return ResultVOUtil.success(map);

    }

    @ApiOperation("获取订单详情")
    @GetMapping("/detail")
    public ResultVO findOrderDetailVOByOrderId(@ApiParam("订单orderId") String orderId){
        return ResultVOUtil.success(orderService.findOrderDetailVOByOrderId(orderId));
    }

    @ApiOperation("支付")
    @PutMapping("/pay")
    public ResultVO pay(@ApiParam("订单orderId") String orderId){
        Map<String,String> map = new HashMap<>();
        map.put("order",orderService.pay(orderId));
        return ResultVOUtil.success(map);

    }



}
