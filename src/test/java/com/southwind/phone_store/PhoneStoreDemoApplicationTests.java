package com.southwind.phone_store;

import com.southwind.phone_store.entity.PhoneCategory;
import com.southwind.phone_store.repository.PhoneCategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PhoneStoreDemoApplicationTests {

    @Autowired
    private PhoneCategoryRepository repository;

    @Test
    void findAll(){
        List<PhoneCategory> list = repository.findAll();
        for (PhoneCategory phoneCategory:list){
            System.out.println(phoneCategory);
        }
    }

    @Test
    void findByCategoryType(){
        PhoneCategory phoneCategory = repository.findByCategoryType(1);
        System.out.println(phoneCategory);
    }


}
