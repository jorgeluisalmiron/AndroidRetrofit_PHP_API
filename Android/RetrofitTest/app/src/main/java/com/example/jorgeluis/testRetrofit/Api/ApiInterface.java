package com.example.jorgeluis.testRetrofit.Api;

/**
 * Created by Jorge Luis on 20/09/2016.
 */



import com.example.jorgeluis.testRetrofit.Model.Alumno;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;


public interface ApiInterface {
    @GET("test/getAll")
    Call<AlumnosResponse> getAll();

    @GET("test/getById")
    Call<AlumnosResponse> getAlumno( @Query("id") int id);

    @POST("test/insert")
    Call<APIResponse>insertAlumno(@Body Alumno alumno);

    @PUT("test/update")
    Call<APIResponse>updateAlumno(@Body Alumno alumno);

    @DELETE("test/delete")
    Call<APIResponse>deleteAlumno(@Query("id") int id);
   /* @GET("movie/{id}")
    Call<Movie> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
*/
    /*
    @GET("movie/{id}")
    Call<MoviesResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
    */
}