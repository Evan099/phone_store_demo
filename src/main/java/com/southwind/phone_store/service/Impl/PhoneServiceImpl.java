package com.southwind.phone_store.service.Impl;

import com.southwind.phone_store.entity.PhoneCategory;
import com.southwind.phone_store.entity.PhoneInfo;
import com.southwind.phone_store.repository.PhoneCategoryRepository;
import com.southwind.phone_store.repository.PhoneInfoRepository;
import com.southwind.phone_store.service.PhoneService;
import com.southwind.phone_store.until.PhoneUntil;
import com.southwind.phone_store.vo.DataVO;
import com.southwind.phone_store.vo.PhoneCategoryVO;
import com.southwind.phone_store.vo.PhoneInfoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneCategoryRepository phoneCategoryRepository;
    @Autowired
    private PhoneInfoRepository phoneInfoRepository;

    @Override
    public DataVO findDataVO() {
        DataVO dataVO = new DataVO();
        //类型
        List<PhoneCategory> phoneCategoryList = phoneCategoryRepository.findAll();

//        常规写法
//        List<PhoneCategoryVO> phoneCategoryVOList = new ArrayList<>();
//        for(PhoneCategory phoneCategory : phoneCategoryList){
//            PhoneCategoryVO phoneCategoryVO = new PhoneCategoryVO();
//            phoneCategoryVO.setCategoryName(phoneCategory.getCategoryName());//为phoneCategoryVO设置phoneCategoryList查出来的参数
//            phoneCategoryVO.setCategoryType((phoneCategory.getCategoryType()));
//            phoneCategoryVOList.add(phoneCategoryVO);//将参数放进phoneCategoryVOList
//        }

//        stream写法
        List<PhoneCategoryVO> phoneCategoryVOList = phoneCategoryList.stream()
                .map(e -> new PhoneCategoryVO(
                    e.getCategoryName(),
                    e.getCategoryType()
        )).collect(Collectors.toList());
                dataVO.setCategories(phoneCategoryVOList);

        //手机
        List<PhoneInfo> phoneInfoList = phoneInfoRepository.findAllByCategoryType(phoneCategoryList.get(0).getCategoryType());

//        常规写法
//        List<PhoneInfoVO> phoneInfoVOList = new ArrayList<>();
//        for(PhoneInfo phoneInfo : phoneInfoList){
//            PhoneInfoVO phoneInfoVO = new PhoneInfoVO();
//            BeanUtils.copyProperties(phoneInfo,phoneInfoVO);//这样就不用挨个写set了
//
//            phoneInfoVO.setTag(PhoneUntil.createTag(phoneInfo.getPhoneTag()));
//            phoneInfoVOList.add(phoneInfoVO);
//        }

//        stream写法
        List<PhoneInfoVO> phoneInfoVOList = new ArrayList<>();




        return null;
    }





}
