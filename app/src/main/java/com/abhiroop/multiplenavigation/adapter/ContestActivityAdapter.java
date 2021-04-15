package com.abhiroop.multiplenavigation.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContestActivityAdapter extends RecyclerView.Adapter<ContestActivityAdapter.ViewHolder> {

    private Context mContext;

    public ContestActivityAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ContestActivityAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ContestActivityAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
