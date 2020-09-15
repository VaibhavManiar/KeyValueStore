package com.halodoc.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GetDataResponse {
    private final String attribute;
    private final Object data;

    @JsonCreator
    public GetDataResponse(@JsonProperty("attribute") String attribute, @JsonProperty("value") Object data) {
        this.attribute = attribute;
        this.data = data;
    }

    public String getAttribute() {
        return attribute;
    }

    public Object getData() {
        return data;
    }
}
