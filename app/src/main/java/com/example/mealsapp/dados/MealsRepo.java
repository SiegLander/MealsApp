package com.example.mealsapp.dados;

import com.example.mealsapp.apimodel.Meals;
import com.example.mealsapp.apimodel.MealsApi;

import java.io.IOException;

public class MealsRepo {

    private MealsApi api;

    public MealsRepo(MealsApi api) {
        this.api = api;
    }

    public Meals buscar() throws IOException {
        Meals m = api.fetch().execute().body();
        return m;
    }
}
