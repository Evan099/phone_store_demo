package com.southwind.phone_store.service.Impl;

import com.southwind.phone_store.Enums.PayStatusEnum;
import com.southwind.phone_store.dto.OrderDTO;
import com.southwind.phone_store.entity.OrderMaster;
import com.southwind.phone_store.entity.PhoneInfo;
import com.southwind.phone_store.entity.PhoneSpecs;
import com.southwind.phone_store.repository.OrderMasterRepository;
import com.southwind.phone_store.repository.PhoneInfoRepository;
import com.southwind.phone_store.repository.PhoneSpecsRepository;
import com.southwind.phone_store.service.OrderService;
import com.southwind.phone_store.service.PhoneService;
import com.southwind.phone_store.until.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
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

        PhoneInfo phoneInfo = phoneInfoRepository.findById(phoneSpecs.getPhoneId()).get();
        BeanUtils.copyProperties(phoneInfo,orderMaster);

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


        return orderDTO;
    }
}
