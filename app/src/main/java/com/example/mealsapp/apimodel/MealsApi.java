package com.example.mealsapp.apimodel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface MealsApi {
    @GET("random.php")
    Call<Meals> fetch();
}
