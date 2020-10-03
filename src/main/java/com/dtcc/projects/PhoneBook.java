package com.dtcc.projects;


import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {

    Map<String, List<String>> phoneBookMap;

    public PhoneBook(){
        this(new LinkedHashMap<String, List<String>>());
    }

    public PhoneBook(Map<String, List<String>> map) {
        this.phoneBookMap = map;
    }

    public void add (String name, String phoneNumber) {
        List<String> phoneNumberList = phoneBookMap.get(name);
        if (phoneNumberList != null) {
            phoneNumberList.add(phoneNumber);
        }
        else {
            phoneBookMap.put(name, Collections.singletonList(phoneNumber));
        }
    }


}
