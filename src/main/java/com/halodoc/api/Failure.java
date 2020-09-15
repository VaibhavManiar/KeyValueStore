package com.halodoc.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Failure extends Response<String> {

    private final Error error;

    @JsonCreator
    public Failure(@JsonProperty("error") Error error) {
        super(Status.Failure.name(), Status.Failure);
        this.error = error;
    }

    public Error getError() {
        return error;
    }

    public static class Error {
        private final String errorMessage;

        @JsonCreator
        public Error(@JsonProperty("errorMessage") String errorMessage) {
            this.errorMessage = errorMessage;
        }

        public String getErrorMessage() {
            return errorMessage;
        }
    }
}
