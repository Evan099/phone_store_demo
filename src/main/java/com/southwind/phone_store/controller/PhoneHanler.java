package com.southwind.phone_store.controller;

import com.southwind.phone_store.service.PhoneService;
import com.southwind.phone_store.until.ResultVOUtil;
import com.southwind.phone_store.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/phone")
@Api(tags = "手机模块")
public class PhoneHanler {

    @Autowired
    private PhoneService phoneService;


    //查询所有手机
    @ApiOperation("查询所有手机")
    @GetMapping("/index")
    public ResultVO index(){
        return ResultVOUtil.success(phoneService.findDataVO());
    }

    //根据类型查询所有手机
    @ApiOperation("根据类型查询所有手机")
    @GetMapping("/findByCategoryType")
    public ResultVO findByCategoryType(Integer categoryType){
        return ResultVOUtil.success(phoneService.findPhoneInfoVOByCategoryType(categoryType));
    }

    //根据phoneId查手机规格
    @ApiOperation("根据phoneId查手机规格")
    @GetMapping("/findSpecsByPhoneId")
    public ResultVO findSpecsByPhoneId(Integer phoneId){
        return ResultVOUtil.success(phoneService.findSpecsByPhoneId(phoneId));
    }


}
