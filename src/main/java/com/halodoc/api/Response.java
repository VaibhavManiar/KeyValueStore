package com.halodoc.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class Response<T> {
    private final T data;
    private final Status status;

    @JsonCreator
    public Response(@JsonProperty("data") T data, @JsonProperty("status") Status status) {
        this.data = data;
        this.status = status;
    }

    public enum Status {
        Success, Failure
    }

    public T getData() {
        return data;
    }


    public Status getStatus() {
        return status;
    }

}
