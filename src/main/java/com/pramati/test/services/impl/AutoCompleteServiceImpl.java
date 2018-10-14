package com.pramati.test.services.impl;

import com.pramati.test.dao.CityDao;
import com.pramati.test.services.AutoCompleteService;
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
