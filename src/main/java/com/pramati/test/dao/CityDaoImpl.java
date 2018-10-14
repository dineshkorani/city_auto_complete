package com.pramati.test.dao;


import com.pramati.test.controllers.AutoCompleteController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import javax.persistence.Query;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

import java.util.List;

@Repository
public class CityDaoImpl implements CityDao {
    List<String> cityList = new ArrayList<>();
    private static final Logger LOGGER= LogManager.getLogger(CityDaoImpl.class);

    @PostConstruct
    public void init() throws IOException {
        ClassPathResource cpr = new ClassPathResource("CityList.csv");
        byte[] bdata = FileCopyUtils.copyToByteArray(cpr.getInputStream());
        String data = new String(bdata, StandardCharsets.UTF_8);
        data =data.toLowerCase();
        cityList = Arrays.asList(data.split("\n"));
    }



    @Override
    public List<String> getCityList(String start, int limit) {
        LOGGER.info("finding {} city with start {}",limit,start);
        start = start.toLowerCase();
        List<String> limitedList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(cityList)) {
            // can use mysql also
            for (String s : cityList) {
                if (s.startsWith(start)) {
                    limitedList.add(s);
                }
                if (limitedList.size() == limit) {
                    return limitedList;
                }
            }
        }
        return limitedList;

    }
}