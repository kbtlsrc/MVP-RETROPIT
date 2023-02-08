package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.myproject.model.Category;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MealContract.MealView{

    @BindView(R.id.rv_meal)
    RecyclerView recyclerView;

    MealPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new MealPresenter(this);
        presenter.getCategories();

    }

    @Override
    public void setCategory(List<Category> category) {
        MealAdapter mealAdapter = new MealAdapter(category, this);
        recyclerView.setAdapter(mealAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        mealAdapter.notifyDataSetChanged();

    }
}