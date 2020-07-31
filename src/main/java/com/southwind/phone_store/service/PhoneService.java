package com.southwind.phone_store.service;

import com.southwind.phone_store.vo.DataVO;
import com.southwind.phone_store.vo.PhoneInfoVO;

import java.util.List;

public interface PhoneService {
    public DataVO findDataVO();

    public List<PhoneInfoVO> findPhoneInfoVOByCategoryType(Integer categoryType);




}
