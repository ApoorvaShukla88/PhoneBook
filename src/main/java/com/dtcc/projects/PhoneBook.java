package com.dtcc.projects;


import java.util.*;

public class PhoneBook {

    static Map<String, List<String>> phoneBookMap;

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
    void addAll(String name, String[] phoneNumbers){
        phoneBookMap.put(name, Arrays.asList(phoneNumbers));

    }
    public static void remove(String name){
        phoneBookMap.remove(name);

    }

    public static boolean hasEntry(String name){
        return phoneBookMap.containsKey(name);
    }

    public List<String> lookup(String name){
        List<String> lookupList = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : phoneBookMap.entrySet()){
            if(entry.getKey().equalsIgnoreCase(name)){
                lookupList = entry.getValue();
            }
        }
        return lookupList;
    }

    public String reverseLookup(String phoneNumber){
        String reversekey = "";
        for(Map.Entry<String, List<String>> entry : phoneBookMap.entrySet()){
            if(entry.getValue().contains(phoneNumber)){
                reversekey = entry.getKey();
            }
        }
        return reversekey;
    }
    public List<String> getAllContactNames(){
        List<String> allnamelist = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : phoneBookMap.entrySet()){
            allnamelist.add(entry.getKey());


        }
        return allnamelist;
    }


}
