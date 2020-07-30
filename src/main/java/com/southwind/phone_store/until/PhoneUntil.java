package com.southwind.phone_store.until;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneUntil {

    public static List<Map<String,String>> createTag(String tag){
        String[] tags = tag.split("&");
        List<Map<String,String>> list = new ArrayList<>();
        Map<String,String> map;
        for (String s :tags){
            map = new HashMap<>();
            map.put("name",s);
            list.add(map);
        }
        return list;
    }


}
