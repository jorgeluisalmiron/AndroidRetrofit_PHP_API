package com.example.jorgeluis.testRetrofit.Api;

/**
 * Created by Jorge Luis on 20/09/2016.
 */
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {

    public static final String BASE_URL = "http://jlatest2017.esy.es/api/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}