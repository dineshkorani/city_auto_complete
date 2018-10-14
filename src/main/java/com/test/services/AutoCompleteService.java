package com.test.services;

import java.util.List;

public interface AutoCompleteService {
    public List<String> getAutoCompleteCities(String start, int limit);
}
