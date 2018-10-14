package com.test.dao;


import java.util.List;

public interface CityDao {
    List<String> getCityList(String start, int limit);
}
