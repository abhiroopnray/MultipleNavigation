package com.abhiroop.multiplenavigation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abhiroop.multiplenavigation.R;

public class BannerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_banner_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            ViewHolder viewHolder = (ViewHolder)holder;
            viewHolder.textView.setText("Some Text" + position);
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item_recycler_banner);
        }
    }
}
