package com.abhiroop.multiplenavigation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abhiroop.multiplenavigation.R;

public class ParticipantAdapter extends RecyclerView.Adapter<ParticipantAdapter.ViewHolder> {

    private Context mContext;

    public ParticipantAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ParticipantAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_participant_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ParticipantAdapter.ViewHolder holder, int position) {
        holder.tv_rank.setText(""+1);
        holder.tv_captain_name.setText("Captain Haddock");
        holder.tv_team_no.setText("Team 1");
        holder.tv_points.setText("10");


    }

    @Override
    public int getItemCount() {
        return 16;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tv_rank, tv_captain_name, tv_team_no, tv_points;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_rank = itemView.findViewById(R.id.tv_rank);
            tv_captain_name = itemView.findViewById(R.id.tv_captain_name);
            tv_team_no = itemView.findViewById(R.id.tv_team_no);
            tv_points = itemView.findViewById(R.id.tv_points);
        }
    }

}
