package com.shreya.dto.response;

import java.io.Serializable;

import com.shreya.Exception.dto.ErrorResponseDTO;
import lombok.Generated;

public class BaseResponseDTO<T extends Serializable> implements Serializable {
    private T response;
    private ErrorResponseDTO errors;
    private String requestId;

    @Generated
    public void setResponse(final T response) {
        this.response = response;
    }

    @Generated
    public void setErrors(final ErrorResponseDTO errors) {
        this.errors = errors;
    }

    @Generated
    public void setRequestId(final String requestId) {
        this.requestId = requestId;
    }

    @Generated
    public T getResponse() {
        return this.response;
    }

    @Generated
    public ErrorResponseDTO getErrors() {
        return this.errors;
    }

    @Generated
    public String getRequestId() {
        return this.requestId;
    }

    @Generated
    public BaseResponseDTO(final T response, final ErrorResponseDTO errors, final String requestId) {
        this.response = response;
        this.errors = errors;
        this.requestId = requestId;
    }
}


