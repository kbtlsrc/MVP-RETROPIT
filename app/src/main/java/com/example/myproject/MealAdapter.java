package com.example.myproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myproject.model.Category;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MealAdapter extends RecyclerView.Adapter<MealAdapter.MealViewHolder> {

    private List<Category> categories;
    private Context context;
    private static clickListener clickListener;

    public MealAdapter(List<Category> categories, Context context) {
        this.categories = categories;
        this.context = context;
    }

    @NonNull
    @Override
    public MealAdapter.MealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MealViewHolder(LayoutInflater.from(context).inflate(R.layout.item_meal, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MealAdapter.MealViewHolder holder, int position) {
        String imgThumb = categories.get(position).getStrCategoryThumb();
        Glide.with(context).load(imgThumb).into(holder.imgCategory);

        String tvName = categories.get(position).getStrCategory();
        holder.tvMeal.setText(tvName);

        holder.tvDesc.setText(categories.get(position).getStrCategoryDescription());

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    static class MealViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.img_meal)
        ImageView imgCategory;
        @BindView(R.id.tv_meal)
        TextView tvMeal;
        @BindView(R.id.tv_desc_meal)
        TextView tvDesc;

        public MealViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickListener.onClick(view,getAdapterPosition());

        }
        public void setOnItemClickListener(clickListener clickListener){
            MealAdapter.clickListener = clickListener;
        }
    }

    public interface clickListener{
        void onClick(View view, int position);
    }
}
