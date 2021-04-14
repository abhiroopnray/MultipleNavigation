package com.abhiroop.multiplenavigation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abhiroop.multiplenavigation.R;

public class WicketKeeperFragmentAdapter extends RecyclerView.Adapter<WicketKeeperFragmentAdapter.ViewHolder> {

    private Context mContext;

    public WicketKeeperFragmentAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public WicketKeeperFragmentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_card_select_player, parent, false);
        WicketKeeperFragmentAdapter.ViewHolder viewHolder = new WicketKeeperFragmentAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WicketKeeperFragmentAdapter.ViewHolder holder, int position) {

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
