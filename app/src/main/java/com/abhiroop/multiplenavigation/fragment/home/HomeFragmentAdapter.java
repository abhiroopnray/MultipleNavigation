package com.abhiroop.multiplenavigation.fragment.home;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.abhiroop.multiplenavigation.R;
import com.abhiroop.multiplenavigation.activity.CreateTeamActivity;

public class HomeFragmentAdapter extends RecyclerView.Adapter<HomeFragmentAdapter.MenuViewHolder > {

    private Context mContext;

    public HomeFragmentAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_card, parent, false);
        MenuViewHolder  holder = new MenuViewHolder (view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeFragmentAdapter.MenuViewHolder  holder, int position) {
        holder.btnCreateTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, CreateTeamActivity.class);
                mContext.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return 10;
    }

      class MenuViewHolder  extends RecyclerView.ViewHolder{
        public Button btnCreateTeam;
                /*, btnJoin, btnMyTeam;*/
        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            btnCreateTeam = itemView.findViewById(R.id.btn_create_team);
            /*btnJoin = itemView.findViewById(R.id.btn_join);
            btnMyTeam = itemView.findViewById(R.id.btn_my_team);*/
        }
    }
}
