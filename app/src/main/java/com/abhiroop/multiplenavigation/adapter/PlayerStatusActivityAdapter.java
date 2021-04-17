package com.abhiroop.multiplenavigation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abhiroop.multiplenavigation.R;

public class PlayerStatusActivityAdapter extends RecyclerView.Adapter<PlayerStatusActivityAdapter.ViewHolder> {

    private Context mContext;

    public PlayerStatusActivityAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public PlayerStatusActivityAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_player_status, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerStatusActivityAdapter.ViewHolder holder, int position) {
        holder.tv_player_name.setText("Virat de Villiars Willamson");
        holder.tv_player_credits.setText("100");
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tv_player_name, tv_player_credits;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_player_name = itemView.findViewById(R.id.tv_player_name);
            tv_player_credits = itemView.findViewById(R.id.tv_player_credits);
        }
    }
}
