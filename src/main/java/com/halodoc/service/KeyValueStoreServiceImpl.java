package com.halodoc.service;

import com.halodoc.api.GetDataResponse;
import com.halodoc.api.SaveApiRequest;
import com.halodoc.store.KeyValueStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class KeyValueStoreServiceImpl implements KeyValueStoreService {

    private final KeyValueStore keyValueStore;

    public KeyValueStoreServiceImpl(@Autowired KeyValueStore keyValueStore) {
        this.keyValueStore = keyValueStore;
    }

    @Override
    public void save(SaveApiRequest request) {
        validateSaveApiRequest(request);
        this.keyValueStore.save(request.getKey(), request.getAttribute(), request.getData());
    }

    private void validateSaveApiRequest(SaveApiRequest request) {
        if(request == null) {
            throw new NullPointerException("Save request is null.");
        }

        if(request.getKey() == null) {
            throw new NullPointerException("Save request key is null.");
        }

        if(request.getAttribute() == null) {
            throw new NullPointerException("Save request attribute is null.");
        }

        if(request.getData() == null) {
            throw new NullPointerException("Save request data is null.");
        }
    }

    @Override
    public List<GetDataResponse> getCities(String key) {
        List<GetDataResponse> result = new ArrayList<>();
        Map<String, Object> dataMap = this.keyValueStore.getValue(key);
        for(Map.Entry<String, Object> entry : dataMap.entrySet()) {
            result.add(new GetDataResponse(entry.getKey(), entry.getValue()));
        }
        return result;
    }

    @Override
    public List<String> getCities(String attribute, String value) {
        return this.keyValueStore.getKey(attribute, value);
    }
}
