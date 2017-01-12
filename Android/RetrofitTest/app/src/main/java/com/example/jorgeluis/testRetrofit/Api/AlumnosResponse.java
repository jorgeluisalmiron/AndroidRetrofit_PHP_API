package com.example.jorgeluis.testRetrofit.Api;

import com.example.jorgeluis.testRetrofit.Model.Alumno;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Jorge Luis on 10/01/2017.
 */
public class AlumnosResponse {


    @SerializedName("errorCode")
    private int errorCode;

    @SerializedName("errorMessage")
    private String errorMessage;

    @SerializedName("results")
    private List<Alumno> results;

    public List<Alumno> getResults() {
        return results;
    }

    public void setResults(List<Alumno> results) {
        this.results = results;
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

    public void setErrorMessage(int String) {
        this.errorMessage = errorMessage;
    }
}

