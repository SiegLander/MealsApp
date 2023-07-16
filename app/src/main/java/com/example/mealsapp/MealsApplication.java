package com.example.mealsapp;

import android.app.Application;

import com.example.mealsapp.apimodel.MealsApi;
import com.example.mealsapp.dados.MealsRepo;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MealsApplication extends Application {
    public ExecutorService executorService = Executors.newFixedThreadPool(1);
    public MealsApi mealsApi;
    public MealsRepo mealsRepo;

    public Executor getExecutor() {
        return executorService;
    }

    public MealsApi getApi() {
        if (mealsApi != null) return mealsApi;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://themealdb.com/api/json/v1/1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mealsApi = retrofit.create(MealsApi.class);

        return mealsApi;
    }

    public MealsRepo getMealsRepo() {
        if (mealsRepo != null) return mealsRepo;

        mealsRepo = new MealsRepo(getApi());
        return mealsRepo;
    }
}
