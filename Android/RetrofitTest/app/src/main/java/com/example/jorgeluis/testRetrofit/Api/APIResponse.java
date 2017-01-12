package com.example.jorgeluis.testRetrofit.Api;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Jorge Luis on 11/01/2017.
 */
public class APIResponse {

    @SerializedName("errorCode")
    private int errorCode;
    @SerializedName("errorMessage")
    private String errorMessage;

    public APIResponse(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }


    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
