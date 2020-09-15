package com.halodoc.store;

import com.halodoc.DataTypeUtil;
import com.halodoc.exception.InvalidDataTypeException;
import com.halodoc.exception.InvalidOperationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class InMemoryKeyValueStore implements KeyValueStore {
    // Key vs Attribute vs Data
    private final Map<String, Map<String, Object>> store = new ConcurrentHashMap<>();

    // Attribute vs Datatype
    private final Map<String, Class<?>> dataTypeMap = new ConcurrentHashMap<>();


    @Override
    public void save(String key, String attribute, Object value) {
        validateDataType(attribute, value);
        Class<?> dataType = DataTypeUtil.getDataType(value);
        dataTypeMap.put(attribute, dataType);

        Map<String, Object> attributeDataMap = store.getOrDefault(key, new ConcurrentHashMap<>());
        /*if (attributeDataMap.containsKey(attribute)) {
            throw new InvalidOperationException("Data updation not allowed. Data already present in store for key : " + key + " and attribute : " + attribute);
        }*/
        attributeDataMap.put(attribute, value);
        store.put(key, attributeDataMap);
    }

    private void validateDataType(String attribute, Object o) {
        Class<?> dataType = dataTypeMap.get(attribute);
        if (dataType != null && !dataType.getName().equalsIgnoreCase(DataTypeUtil.getDataType(o).getName())) {
            throw new InvalidDataTypeException("Invalid data type for attribute : " + attribute + ". Expected Data Type : " + dataType.getName());
        }
    }

    @Override
    public Map<String, Object> getValue(String key) {
        return store.getOrDefault(key, new ConcurrentHashMap<>());
    }

    @Override
    public List<String> getKey(String subKey, Object subValue) {
        return store.entrySet().stream().filter(e -> e.getValue().containsKey(subKey)
                && e.getValue().getOrDefault(subKey, "").equals(subValue)).map(Map.Entry::getKey).collect(Collectors.toList());
    }


}
