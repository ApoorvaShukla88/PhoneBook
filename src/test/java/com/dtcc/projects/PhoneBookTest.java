package com.dtcc.projects;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PhoneBookTest {

    @Test
    public void addTest(){
        PhoneBook phoneBook = new PhoneBook();
        String name = "Zan";
        String phoneNumber = "123432152";
        phoneBook.add(name, phoneNumber);
        Assert.assertTrue(phoneBook.phoneBookMap.containsKey(name));
        Assert.assertEquals(phoneNumber,phoneBook.phoneBookMap.get(name).get(0));
    }

    @Test
    public void addAllTest(){
        PhoneBook phoneBook = new PhoneBook();
        String name = "Zan Again";
        String[] phoneNumbers = {"1122", "34567", "134789"};
        phoneBook.addAll(name, phoneNumbers);
        Assert.assertEquals(Arrays.asList(phoneNumbers), phoneBook.phoneBookMap.get(name));
    }

    @Test
    public void removeTest(){
        PhoneBook phoneBook = new PhoneBook();
        String name = "Zan";
        String phoneNumber = "33333333333";
        phoneBook.add(name, phoneNumber);
        String name1 = "Zan1";
        String phoneNumber1 = "333333333331";
        phoneBook.add(name1, phoneNumber1);
        phoneBook.remove(name);
        Assert.assertFalse(phoneBook.phoneBookMap.containsKey("Zan"));
    }

    @Test
    public void hasEntryTest(){
        PhoneBook phoneBook1 = new PhoneBook();
        String name = "Zan";
        String phoneNumber = "33333333333";
        phoneBook1.add(name, phoneNumber);
        Assert.assertTrue(phoneBook1.phoneBookMap.containsKey("Zan"));
    }

    @Test
    public void lookupTest(){
        PhoneBook phoneBook1 = new PhoneBook();
        String name = "Zan";
        String[] phoneNumberList = {"33333333333", "1234", "123456"};
        phoneBook1.addAll(name, phoneNumberList);
        List<String> names = phoneBook1.lookup(name);
        Assert.assertEquals(Arrays.asList(phoneNumberList), names);

    }
    @Test
    public void reverseLookupTest(){
        PhoneBook phoneBook1 = new PhoneBook();
        String name = "Zan";
        String phoneNumber = "33333333333";
        phoneBook1.add(name, phoneNumber);
        Assert.assertEquals(phoneBook1.reverseLookup(phoneNumber),
                name);
    }

    @Test
    public void getAllContactNamesTest(){
        PhoneBook phoneBook1 = new PhoneBook();
        String name1 = "Zan";
        String[] phoneNumber1 = {"33333333333", "123"};
        phoneBook1.addAll(name1, phoneNumber1);
        String name2="Zan2";
        String[] phoneNumber2 = {"999999999", "22222222222","44444444444"};
        phoneBook1.addAll(name2, phoneNumber2);
        String[] actual={"Zan","Zan2"};
        Assert.assertEquals(Arrays.asList(actual), phoneBook1.getAllContactNames());
    }



}
