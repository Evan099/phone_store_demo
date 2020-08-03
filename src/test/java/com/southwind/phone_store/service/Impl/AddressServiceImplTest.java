package com.southwind.phone_store.service.Impl;

import com.southwind.phone_store.form.AddressForm;
import com.southwind.phone_store.service.AddressService;
import com.southwind.phone_store.vo.AddressVO;
import org.apache.tomcat.jni.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AddressServiceImplTest {

    @Autowired
    private AddressService addressService;

    @Test
    void findAll(){
        List<AddressVO> list = addressService.findAll();
        int id = 0;
    }

    @Test
    void saveOrUpdate(){
        AddressForm addressForm = new AddressForm();

//        addressForm.setId(9);
        addressForm.setName("姚明9");
        addressForm.setTel("13266669998");
        addressForm.setProvince("北京市");
        addressForm.setCity("北京市");
        addressForm.setCounty("朝阳区");
        addressForm.setAreaCode("10000");
        addressForm.setAddressDetail("168号2203室");

        addressService.saveOrUpdate(addressForm);
    }

}