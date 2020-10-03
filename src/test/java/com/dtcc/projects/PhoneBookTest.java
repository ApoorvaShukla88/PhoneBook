package com.dtcc.projects;

import org.junit.Assert;
import org.junit.Test;

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
}
