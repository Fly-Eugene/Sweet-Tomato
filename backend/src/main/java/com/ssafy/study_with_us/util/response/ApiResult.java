package com.ssafy.study_with_us.util.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ApiResult<T> {
    private int status;
    private String message;
    private T data;

    public ApiResult() {
    }

    @Builder
    public ApiResult(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

}
