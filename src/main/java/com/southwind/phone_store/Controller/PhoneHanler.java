package com.southwind.phone_store.Controller;

import com.southwind.phone_store.service.PhoneService;
import com.southwind.phone_store.until.ResultVOUtil;
import com.southwind.phone_store.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/phone")
public class PhoneHanler {

    @Autowired
    private PhoneService phoneService;

    @GetMapping("/index")
    public ResultVO index(){//查询所有手机
        return ResultVOUtil.success(phoneService.findDataVO());
    }


    @GetMapping("/findByCategoryType/{categoryType}")
    public ResultVO findByCategoryType(@PathVariable("categoryType") Integer categoryType){//根据类型查询所有手机
        return ResultVOUtil.success(phoneService.findPhoneInfoVOByCategoryType(categoryType));
    }


    @GetMapping("/findSpecsByPhoneId/{phoneId}")
    public ResultVO findSpecsByPhoneId(@PathVariable("phoneId") Integer phoneId){
        return ResultVOUtil.success(phoneService.findSpecsByPhoneId(phoneId));
    }


}
