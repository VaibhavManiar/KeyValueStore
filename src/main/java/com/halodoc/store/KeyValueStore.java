package com.halodoc.store;

import java.util.List;
import java.util.Map;

public interface KeyValueStore {
    void save(String key, String attribute, Object value);

    Map<String, Object> getValue(String key);

    List<String> getKey(String subKey, Object subValue);
}
