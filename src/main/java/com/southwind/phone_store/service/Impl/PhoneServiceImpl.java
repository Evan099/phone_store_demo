package com.southwind.phone_store.service.Impl;

import com.southwind.phone_store.entity.PhoneCategory;
import com.southwind.phone_store.entity.PhoneInfo;
import com.southwind.phone_store.entity.PhoneSpecs;
import com.southwind.phone_store.repository.PhoneCategoryRepository;
import com.southwind.phone_store.repository.PhoneInfoRepository;
import com.southwind.phone_store.repository.PhoneSpecsRepository;
import com.southwind.phone_store.service.PhoneService;
import com.southwind.phone_store.until.PhoneUntil;
import com.southwind.phone_store.vo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneCategoryRepository phoneCategoryRepository;
    @Autowired
    private PhoneInfoRepository phoneInfoRepository;
    @Autowired
    private PhoneSpecsRepository phoneSpecsRepository;



    @Override
    public DataVO findDataVO() {//查询所有手机信息
        DataVO dataVO = new DataVO();
        //类型VO
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

        //手机VO
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

        List<PhoneInfoVO> phoneInfoVOList = phoneInfoList.stream()
                .map(e -> new PhoneInfoVO(
                        e.getPhoneId(),
                        e.getPhoneName(),
                        e.getPhonePrice(),
                        e.getPhoneDescription()+".00",
                        PhoneUntil.createTag(e.getPhoneTag()),
                        e.getPhoneIcon()
                )).collect(Collectors.toList());

        dataVO.setPhones(phoneInfoVOList);
        return dataVO;


    }

    @Override
    public List<PhoneInfoVO> findPhoneInfoVOByCategoryType(Integer categoryType){//通过规格类型查询所有手机信息

        List<PhoneInfo> phoneInfoList = phoneInfoRepository.findAllByCategoryType(categoryType);

        List<PhoneInfoVO> phoneInfoVOList = phoneInfoList.stream()
                .map(e -> new PhoneInfoVO(
                        e.getPhoneId(),
                        e.getPhoneName(),
                        e.getPhonePrice(),
                        e.getPhoneDescription(),
                        PhoneUntil.createTag(e.getPhoneTag()),
                        e.getPhoneIcon()

                )).collect(Collectors.toList());

        return phoneInfoVOList;

    }

    @Override
    public SpecsPackageVO findSpecsByPhoneId(Integer phoneId) {//通过phoneId查询手机规格

        PhoneInfo phoneInfo = phoneInfoRepository.findById(phoneId).get();

        List<PhoneSpecs> phoneSpecsList = phoneSpecsRepository.findAllByPhoneId(phoneId);

        //tree
        List<PhoneSpecsVO> phoneSpecsVOList = new ArrayList<>();
        List<PhoneSpecsCasVO> phoneSpecsCasVOList = new ArrayList<>();
        PhoneSpecsVO phoneSpecsVO;
        PhoneSpecsCasVO phoneSpecsCasVO;

        for (PhoneSpecs phoneSpecs : phoneSpecsList) {
            phoneSpecsVO = new PhoneSpecsVO();
            phoneSpecsCasVO = new PhoneSpecsCasVO();
            BeanUtils.copyProperties(phoneSpecs,phoneSpecsVO);
            BeanUtils.copyProperties(phoneSpecs,phoneSpecsCasVO);
            phoneSpecsVOList.add(phoneSpecsVO);
            phoneSpecsCasVOList.add(phoneSpecsCasVO);
        }

        TreeVO treeVO = new TreeVO();
        treeVO.setV(phoneSpecsVOList);
        List<TreeVO> treeVOList = new ArrayList<>();
        treeVOList.add(treeVO);

        SkuVO skuVO = new SkuVO();
        Integer price = phoneInfo.getPhonePrice().intValue();
        skuVO.setPrice(price+".00");
        skuVO.setStock_num(phoneInfo.getPhoneStock());
        skuVO.setList(phoneSpecsCasVOList);

        SpecsPackageVO specsPackageVO = new SpecsPackageVO();
        specsPackageVO.setSku(skuVO);
        Map<String,String> goods = new HashMap<>();
        goods.put("picture",phoneInfo.getPhoneIcon());
        specsPackageVO.setGoods(goods);


        return specsPackageVO;
    }









}
