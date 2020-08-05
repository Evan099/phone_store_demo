package com.southwind.phone_store.service.Impl;

import com.southwind.phone_store.service.PhoneService;
import com.southwind.phone_store.vo.DataVO;
import com.southwind.phone_store.vo.PhoneInfoVO;
import com.southwind.phone_store.vo.SpecsPackageVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class PhoneServiceImplTest {
    @Autowired
    private PhoneService phoneService;


    @Test
    void findDataVO(){
        DataVO dataVO = phoneService.findDataVO();

        int id = 0;

    }

    @Test
    void findPhoneInfoVOByCategoryType(){
        List<PhoneInfoVO> list = phoneService.findPhoneInfoVOByCategoryType(1);
        int id = 0;
    }

    @Test
    void findSku(){
        SpecsPackageVO specsPackageVO = phoneService.findSpecsByPhoneId(1);
        int id = 1;
    }

    @Test
    void subStock(){
        phoneService.subStock(1,1);
    }

}