package com.southwind.phone_store.service.Impl;

import com.southwind.phone_store.entity.BuyerAddress;
import com.southwind.phone_store.form.AddressForm;
import com.southwind.phone_store.repository.BuyerAddressRepository;
import com.southwind.phone_store.service.AddressService;
import com.southwind.phone_store.vo.AddressVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private BuyerAddressRepository buyerAddressRepository;


    @Override
    public List<AddressVO> findAll() {
        List<AddressVO> list = buyerAddressRepository.findAll().stream()
                .map(e -> new AddressVO(
                        e.getAddressId(),
                        e.getAreaCode(),
                        e.getBuyerName(),
                        e.getBuyerPhone(),
                        e.getBuyerAddress()
                )).collect(Collectors.toList());

        return list;
    }

    @Override
    public void saveOrUpdate(AddressForm addressForm) {
        BuyerAddress buyerAddress;
        if(addressForm.getId() == null){
            buyerAddress = new BuyerAddress();
        }else{
            buyerAddress = buyerAddressRepository.findById(addressForm.getId()).get();
        }

        buyerAddress.setBuyerName(addressForm.getName());
        buyerAddress.setBuyerPhone(addressForm.getTel());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(addressForm.getProvince())
                .append(addressForm.getCity())
                .append(addressForm.getCounty())
                .append(addressForm.getAddressDetail());

        buyerAddress.setBuyerAddress(stringBuffer.toString());
        buyerAddress.setAreaCode(addressForm.getAreaCode());

        buyerAddressRepository.save(buyerAddress);

    }
}
