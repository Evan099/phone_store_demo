package com.southwind.phone_store.service.Impl;

import com.southwind.phone_store.enums.PayStatusEnum;
import com.southwind.phone_store.dto.OrderDTO;
import com.southwind.phone_store.entity.OrderMaster;
import com.southwind.phone_store.entity.PhoneInfo;
import com.southwind.phone_store.entity.PhoneSpecs;
import com.southwind.phone_store.enums.ResultEnum;
import com.southwind.phone_store.exception.PhoneException;
import com.southwind.phone_store.repository.OrderMasterRepository;
import com.southwind.phone_store.repository.PhoneInfoRepository;
import com.southwind.phone_store.repository.PhoneSpecsRepository;
import com.southwind.phone_store.service.OrderService;
import com.southwind.phone_store.service.PhoneService;
import com.southwind.phone_store.until.KeyUtil;
import com.southwind.phone_store.vo.OrderDetailVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private PhoneSpecsRepository phoneSpecsRepository;
    @Autowired
    private PhoneInfoRepository phoneInfoRepository;
    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Autowired
    private PhoneService phoneService;


    @Override
    public OrderDTO creat(OrderDTO orderDTO) {
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO,orderMaster);

        PhoneSpecs phoneSpecs = phoneSpecsRepository.findById(orderDTO.getSpecsId()).get();
        BeanUtils.copyProperties(phoneSpecs,orderMaster);
        if(phoneSpecs == null){
            log.error("【查询规格】规格不存在,orderMaster={}",orderMaster);
            throw new PhoneException(ResultEnum.SPECS_NOT_EXITS);
        }

        PhoneInfo phoneInfo = phoneInfoRepository.findById(phoneSpecs.getPhoneId()).get();
        BeanUtils.copyProperties(phoneInfo,orderMaster);
        if(phoneInfo == null){
            log.error("【查询手机】手机不存在,orderMaster={}",orderMaster);
            throw new PhoneException(ResultEnum.PHONE_NOT_EXITS);
        }

        //计算总价
        BigDecimal orderAmount = new BigDecimal(0);
        orderAmount =phoneSpecs.getSpecsPrice().divide(new BigDecimal(100))
                .multiply(new BigDecimal(orderDTO.getPhoneQuantity()))
                .add(orderAmount);
        orderMaster.setOrderAmount(orderAmount);

        //orderId
        orderMaster.setOrderId(KeyUtil.createUniqueKey());
        orderDTO.setOrderId(orderMaster.getOrderId());

        //payStatus
        orderMaster.setPayStatus(PayStatusEnum.UNPIAD.getCode());
        orderMasterRepository.save(orderMaster);

        //改库存
        phoneService.subStock(orderDTO.getSpecsId(),orderDTO.getPhoneQuantity());

        return orderDTO;
    }

    @Override
    public OrderDetailVO findOrderDetailVOByOrderId(String orderId) {
        OrderDetailVO orderDetailVO = new OrderDetailVO();
        OrderMaster orderMaster = orderMasterRepository.findById(orderId).get();

        if(orderMaster == null){
            log.error("【查询订单】订单不存在,orderMaster={}",orderMaster);
            throw new PhoneException(ResultEnum.ORDER_NOT_EXIST);
        }


        BeanUtils.copyProperties(orderMaster,orderDetailVO);
        return orderDetailVO;

    }

    @Override
    public String pay(String orderId) {
        OrderMaster orderMaster = orderMasterRepository.findById(orderId).get();

        if(orderMaster == null){
            log.error("【支付订单】订单不存在,orderMaster={}",orderMaster);
            throw new PhoneException(ResultEnum.ORDER_NOT_EXIST);
        }

        if(orderMaster.getPayStatus().equals(PayStatusEnum.UNPIAD.getCode())){
            orderMaster.setPayStatus(PayStatusEnum.PAID.getCode());
            orderMasterRepository.save(orderMaster);
        }else{
            log.error("【支付订单】订单已支付,orderMaster={}",orderMaster);
        }


        return orderId;
    }
}
