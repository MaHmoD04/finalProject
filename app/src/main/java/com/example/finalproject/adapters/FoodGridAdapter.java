package com.example.finalproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.finalproject.FoodItem;
import com.example.finalproject.R;

import java.util.List;

public class FoodGridAdapter extends BaseAdapter {
        Context context;
        List<FoodItem> items;
        public FoodGridAdapter(Context context, List<FoodItem> items) {
            this.context = context;
            this.items = items;
        }
        @Override
        public int getCount() {
            return items.size();
        }
        @Override
        public Object getItem(int position) {
            return items.get(position);
        }
        @Override
        public long getItemId(int position) {
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.card_food, parent, false);
            }
            ImageView imgFood = convertView.findViewById(R.id.imgFood);
            TextView tvTime = convertView.findViewById(R.id.tvTime);
            TextView tvRating = convertView.findViewById(R.id.tvRating);
            FoodItem item = items.get(position);
            imgFood.setImageResource(item.imageRes);
            tvTime.setText(item.time);
            tvRating.setText(item.rating);
            return convertView;


    }
}
