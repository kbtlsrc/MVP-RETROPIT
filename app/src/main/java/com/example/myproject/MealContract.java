package com.example.myproject;

import com.example.myproject.model.Categories;
import com.example.myproject.model.Category;

import java.util.List;

public interface MealContract {

    interface MealView{

        void setCategory(List<Category> category);
    }
}
