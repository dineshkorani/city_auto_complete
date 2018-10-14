package com.test.services.impl;

import com.test.dao.CityDao;
import com.test.services.AutoCompleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("autoCompleteService")
public class AutoCompleteServiceImpl implements AutoCompleteService{
    @Autowired
    private CityDao cityDao;

    @Override
    public List<String> getAutoCompleteCities(String start, int limit) {
        return cityDao.getCityList(start,limit);
    }
}
