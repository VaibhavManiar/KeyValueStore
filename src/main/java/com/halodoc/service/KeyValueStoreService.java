package com.halodoc.service;

import com.halodoc.api.GetDataResponse;
import com.halodoc.api.SaveApiRequest;

import java.util.List;

public interface KeyValueStoreService {
    void save(SaveApiRequest request);
    List<GetDataResponse> getCities(String key);
    List<String> getCities(String attribute, String value);
}
