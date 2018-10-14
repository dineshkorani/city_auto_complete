package com.test.models;

import java.util.HashMap;
import java.util.Map;

public class DataExchange {

    private Map<String, Object> meta = new HashMap<>();
    private Map<String, Object> data = new HashMap<>();

    public Map<String, Object> getMeta() {
        return meta;
    }

    public void setMeta(Map<String, Object> meta) {
        this.meta = meta;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public void putMeta(String key, Object value) {
        this.meta.put(key, value);
    }

    public Object getMeta(String key) {
        return this.meta.get(key);
    }

    public void putData(String key, Object value) {
        this.data.put(key, value);
    }

    public Object getData(String key) {
        return this.data.get(key);
    }
}
