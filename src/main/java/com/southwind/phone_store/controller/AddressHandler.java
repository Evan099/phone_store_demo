package com.southwind.phone_store.controller;

import com.southwind.phone_store.exception.PhoneException;
import com.southwind.phone_store.form.AddressForm;
import com.southwind.phone_store.service.AddressService;
import com.southwind.phone_store.until.ResultVOUtil;
import com.southwind.phone_store.vo.ResultVO;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/address")
@Slf4j
public class AddressHandler {

    @Autowired
    private AddressService addressService;

    @ApiOperation("获取所有地址")
    @GetMapping("/list")
    public ResultVO list(){
        return ResultVOUtil.success(addressService.findAll());
    }


    @ApiOperation("创建一个地址")
    @PostMapping("/create")
    public ResultVO create(@Valid @RequestBody AddressForm addressForm , BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【添加地址】参数错误，addressForm={}",addressForm);
            throw new PhoneException(bindingResult.getFieldError().getDefaultMessage());
        }

        addressService.saveOrUpdate(addressForm);

        return ResultVOUtil.success(null);
    }

    @ApiOperation("修改一个地址")
    @PutMapping("/update")
    public ResultVO update(@Valid @RequestBody AddressForm addressForm , BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【修改地址】参数错误，addressForm={}",addressForm);
            throw new PhoneException(bindingResult.getFieldError().getDefaultMessage());
        }

        addressService.saveOrUpdate(addressForm);

        return ResultVOUtil.success(null);
    }



}
