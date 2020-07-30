package com.southwind.phone_store.repository;

import com.southwind.phone_store.entity.BuyerAddress;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BuyerAddressRepositoryTest {

    @Autowired
    private BuyerAddressRepository repository;

    @Test
    void findAll(){
        List<BuyerAddress> list = repository.findAll();
        for (BuyerAddress buyerAddress : list){
            System.out.println(buyerAddress);
        }
    }

    @Test
    void save(){
        BuyerAddress buyerAddress = new BuyerAddress();
        buyerAddress.setAreaCode("610001");
        buyerAddress.setBuyerAddress("四川省成都市高新区软件园A区3308");
        buyerAddress.setBuyerName("小露");
        buyerAddress.setBuyerPhone("18289898989");
        repository.save(buyerAddress);
    }

    @Test
    void update(){
        BuyerAddress buyerAddress = repository.findById(5).get();
        buyerAddress.setBuyerName("小露露");
        repository.save(buyerAddress);
    }



}