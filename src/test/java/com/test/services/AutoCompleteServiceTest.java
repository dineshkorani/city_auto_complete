package com.test.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AutoCompleteServiceTest {
    @Autowired
    private AutoCompleteService autoCompleteService ;

    @Test
    public void testGetAutoCompleteCities() {
        List<String> cityList = autoCompleteService.getAutoCompleteCities("ch",2);
        Assert.assertEquals("City list size should be 2",2,cityList.size());
        Assert.assertTrue("City is not starting with start",cityList.get(0).startsWith("ch"));
    }

}
