package com.abhiroop.multiplenavigation.adapter;

import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abhiroop.multiplenavigation.R;
import com.abhiroop.multiplenavigation.activity.CreateTeamActivity;

public class BatsmanFragmentAdapter extends RecyclerView.Adapter<BatsmanFragmentAdapter.ViewHolder> {

    private Context mContext;
    private SparseBooleanArray itemStateArray = new SparseBooleanArray();
    private CreateTeamActivity mCreateTeamActivity;



    public BatsmanFragmentAdapter(Context context, CreateTeamActivity createTeamActivity) {
        mContext = context;
        mCreateTeamActivity = createTeamActivity;
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

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView iv_add_player;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_add_player = itemView.findViewById(R.id.iv_add_player);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            if (!itemStateArray.get(adapterPosition, false)) {
                if (itemStateArray.size() > 5) {
                    Toast.makeText(mContext, R.string.cannot_have_more_batsman, Toast.LENGTH_SHORT).show();
                    return;
                }
                iv_add_player.setImageResource(R.drawable.ic_menu_close_clear_cancel);
                itemStateArray.put(adapterPosition, true);
                mCreateTeamActivity.addPlayersToTeam("Batsman" + getAdapterPosition());


            } else {
                iv_add_player.setImageResource(R.drawable.ic_menu_btn_add);
                itemStateArray.put(adapterPosition, false);
                mCreateTeamActivity.deletePlayersToTeam("Batsman" + getAdapterPosition());

            }
        }
    }
}
