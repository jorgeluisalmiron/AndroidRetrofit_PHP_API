package com.example.jorgeluis.testRetrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;


import com.example.jorgeluis.testRetrofit.Api.APIResponse;
import com.example.jorgeluis.testRetrofit.Api.AlumnosResponse;
import com.example.jorgeluis.testRetrofit.Api.ApiClient;
import com.example.jorgeluis.testRetrofit.Api.ApiInterface;

import com.example.jorgeluis.testRetrofit.Model.Alumno;


import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

        private static final String TAG = MainActivity.class.getSimpleName();


        @Bind(R.id.buttonDelete) Button buttonDelete;
        @Bind(R.id.buttonGetAll) Button buttonGetAll;
        @Bind(R.id.buttonGetById) Button buttonGetById;
        @Bind(R.id.buttonInsert) Button buttonInsert;
        @Bind(R.id.buttonUpdate) Button buttonUpdate;
        @Bind(R.id.texto) TextView texto;

        RecyclerView recyclerView;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            ButterKnife.bind(this);

            recyclerView = (RecyclerView) findViewById(R.id.RecyclerView);

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

            recyclerView.setLayoutManager(linearLayoutManager);




        }

        @OnClick(R.id.buttonGetAll)
        public void getAll()
        {
            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
            Call<AlumnosResponse> call = apiService.getAll();

            call.enqueue(new Callback<AlumnosResponse>() {
                @Override
                public void onResponse(Call<AlumnosResponse> call, Response<AlumnosResponse> response) {


                    int statusCode = response.code();

                    if (statusCode==200) { //OK
                        Log.d("JLA", "CODE: " + response.code());
                        Log.d("JLA", "BACKEND ERROR CODE: " + response.body().getErrorCode());
                        Log.d("JLA", "BACKEND ERROR MESSAGE: " + response.body().getErrorMessage());
                        List<Alumno> list = response.body().getResults();
                        texto.setText("Listado:");
                        recyclerView.setAdapter(new AlumnosAdapter(list, R.layout.list_item_movie, getApplicationContext()));
                    }
                }

                @Override
                public void onFailure(Call<AlumnosResponse> call, Throwable t) {
                    // Log error here since request failed
                    Log.e(TAG, t.toString());
                }
            });

        }

        @OnClick(R.id.buttonGetById)
        public void getById(){
            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
            Call<AlumnosResponse> call = apiService.getAlumno(5);

            call.enqueue(new Callback<AlumnosResponse>() {
                @Override
                public void onResponse(Call<AlumnosResponse> call, Response<AlumnosResponse> response) {


                    int statusCode = response.code();
                    if (statusCode==200) { //OK
                        Log.d("JLA", "CODE: " + response.code());
                        Log.d("JLA", "CODE: " + response.headers());
                        List<Alumno> list = response.body().getResults();
                        texto.setText("Listado:");
                        recyclerView.setAdapter(new AlumnosAdapter(list, R.layout.list_item_movie, getApplicationContext()));
                    }
                }

                @Override
                public void onFailure(Call<AlumnosResponse> call, Throwable t) {
                    // Log error here since request failed
                    Log.e(TAG, t.toString());
                }
            });

        }

        @OnClick(R.id.buttonInsert)
        public void insert()
        {
            Alumno a = new Alumno(-1,"Charles","Holland");
            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
            Call<APIResponse> call = apiService.insertAlumno(a);

            call.enqueue(new Callback<APIResponse>() {
                @Override
                public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {


                    int statusCode = response.code();

                    if (statusCode==200) { //OK
                        Log.d("JLA", "CODE: " + response.code());
                        Log.d("JLA", "BACKEND MESSAGE: " + response.body().getErrorMessage());
                        texto.setText("INSERT - BACKEND MESSAGE: " + response.body().getErrorMessage());
                    }
                    else
                    {
                        texto.setText("ERROR INSERT");
                    }
                }

                @Override
                public void onFailure(Call<APIResponse> call, Throwable t) {
                    // Log error here since request failed
                    Log.e(TAG, t.toString());
                }
            });

        }

    @OnClick(R.id.buttonUpdate)
    public void update() {
        Alumno a = new Alumno(7, "Alumnno 5 Actualizado", "Direccion actualizada");
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<APIResponse> call = apiService.updateAlumno(a);

        call.enqueue(new Callback<APIResponse>() {
            @Override
            public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {


                int statusCode = response.code();
                if (statusCode == 200) { //OK
                    Log.d("JLA", "CODE: " + response.code());
                    Log.d("JLA", "BACKEND MESSAGE: " + response.body().getErrorMessage());
                    texto.setText("UPDATE -- BACKEND MESSAGE: " + response.body().getErrorMessage());
                }
                else
                {
                    texto.setText("ERROR UPDATE");
                }
            }

            @Override
            public void onFailure(Call<APIResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }

        @OnClick(R.id.buttonDelete)
        public void delete()
        {

            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
            Call<APIResponse> call = apiService.deleteAlumno(11);

            call.enqueue(new Callback<APIResponse>() {
                @Override
                public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {


                    int statusCode = response.code();
                    if (statusCode == 200) { //OK
                        Log.d("JLA", "CODE: " + response.code());
                        Log.d("JLA", "BACKEND MESSAGE: " + response.body().getErrorMessage());
                        texto.setText("DELETE -- BACKEND MESSAGE: " + response.body().getErrorMessage());
                    }
                    else
                    {
                        texto.setText("ERROR DELETE");
                    }
                }

                @Override
                public void onFailure(Call<APIResponse> call, Throwable t) {
                    // Log error here since request failed
                    Log.e(TAG, t.toString());
                }
            });
        }
    }

