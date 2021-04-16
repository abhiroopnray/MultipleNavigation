package com.abhiroop.multiplenavigation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abhiroop.multiplenavigation.R;

public class WinningBreakUpDialogAdapter extends RecyclerView.Adapter<WinningBreakUpDialogAdapter.ViewHolder> {
    private Context mContext;

    public WinningBreakUpDialogAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public WinningBreakUpDialogAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_winning_break_up, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WinningBreakUpDialogAdapter.ViewHolder holder, int position) {
           holder.tv_rank.setText("Rank :" + position +1);
           holder.tv_winning_break_up.setText(""+position + 50);
    }

    @Override
    public int getItemCount() {
        return 15;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tv_rank, tv_winning_break_up;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_rank = itemView.findViewById(R.id.tv_rank);
            tv_winning_break_up = itemView.findViewById(R.id.tv_winning_breakup_amount);
        }
    }
}
