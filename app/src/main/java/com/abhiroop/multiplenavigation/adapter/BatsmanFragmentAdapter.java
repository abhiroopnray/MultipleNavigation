package com.abhiroop.multiplenavigation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abhiroop.multiplenavigation.R;

public class BatsmanFragmentAdapter extends RecyclerView.Adapter<BatsmanFragmentAdapter.ViewHolder> {

    private Context mContext;

    public BatsmanFragmentAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public BatsmanFragmentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_card_select_player, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BatsmanFragmentAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 15;
    }


    class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
