package com.study.bookcafe.common;

import com.google.gson.Gson;

public class ApiResult {
    private boolean isSuccess;
    private String message;
    private Object data;

    public ApiResult(boolean isSuccess, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
    }
    public ApiResult(boolean isSuccess, Object data, String message) {
        this.isSuccess = isSuccess;
        this.data = data;
        this.message = message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
