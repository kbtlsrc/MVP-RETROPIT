package com.example.myproject;

import com.example.myproject.model.Categories;
import com.example.myproject.service.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MealPresenter {
    private MealContract.MealView mealView;

    public MealPresenter(MealContract.MealView mealView) {
        this.mealView = mealView;
    }

    void getCategories(){
        Call<Categories> categories = RetrofitService.getApi().getCategories();

        categories.enqueue(new Callback<Categories>() {
            @Override
            public void onResponse(Call<Categories> call, Response<Categories> response) {
                if(response.isSuccessful()&& response.body() != null){
                    mealView.setCategory(response.body().getCategories());
                }
            }

            @Override
            public void onFailure(Call<Categories> call, Throwable t) {

            }
        });
    }
}
