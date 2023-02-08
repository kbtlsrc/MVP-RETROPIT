package com.example.myproject.service;

import com.example.myproject.model.Categories;
import com.example.myproject.model.Meals;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IMeal {
    @GET("categories.php")
    Call<Categories> getCategories();

}
