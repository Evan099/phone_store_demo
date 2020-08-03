package com.southwind.phone_store.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AddressForm {//对前端过来的数据进行校验

    private Integer id;
    @NotEmpty(message = "姓名不能为空")
    private String name;
    @NotEmpty(message = "电话不能为空")
    private String tel;
    @NotEmpty(message = "省不能为空")
    private String province;
    @NotEmpty(message = "市州不能为空")
    private String city;
    @NotEmpty(message = "区县不能为空")
    private String county;
    @NotEmpty(message = "编码不能为空")
    private String areaCode;
    @NotEmpty(message = "详细地址不能为空")
    private String addressDetail;


}
