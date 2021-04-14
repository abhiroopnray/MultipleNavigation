package com.abhiroop.multiplenavigation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abhiroop.multiplenavigation.R;

import java.util.ArrayList;

public class LiveFragmentAdapter extends RecyclerView.Adapter<LiveFragmentAdapter.ViewHolder> {
    private Context mContext;
    private TextView iv;
    private ArrayList<TextView> tvItems = new ArrayList<>();

    public LiveFragmentAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public LiveFragmentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_card_live, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LiveFragmentAdapter.ViewHolder holder, int position) {
        tvItems.add(holder.tvLive);
        Animation anim = new AlphaAnimation(0.2f, 1.0f);
        anim.setDuration(1000); //You can manage the blinking time with this parameter
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        holder.tvLive.startAnimation(anim);
        iv = holder.tvLive;
    }

    public void startAnimation() {
        Animation anim = new AlphaAnimation(0.2f, 1.0f);
        anim.setDuration(1000); //You can manage the blinking time with this parameter
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        if (!tvItems.isEmpty()) {
            for (TextView tv : tvItems)
                tv.startAnimation(anim);
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvLive;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvLive = itemView.findViewById(R.id.tv_live);
        }
    }
}
