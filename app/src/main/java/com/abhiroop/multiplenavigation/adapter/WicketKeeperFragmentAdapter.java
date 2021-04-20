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

public class WicketKeeperFragmentAdapter extends RecyclerView.Adapter<WicketKeeperFragmentAdapter.ViewHolder> {

    private Context mContext;
    private WicketKeeperFragmentAdapter.ViewHolder viewHolder;
    private boolean playerElected = false;
    private int wicketKeeperLimit;
    private ImageView iv_add_player;
    private SparseBooleanArray itemStateArray = new SparseBooleanArray();
    private CreateTeamActivity mCreateTeamActivity;

    public WicketKeeperFragmentAdapter(Context context, CreateTeamActivity createTeamActivity) {
        mContext = context;
        mCreateTeamActivity = createTeamActivity;
    }

    @NonNull
    @Override
    public WicketKeeperFragmentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_card_select_player, parent, false);
        viewHolder = new WicketKeeperFragmentAdapter.ViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull WicketKeeperFragmentAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 15;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
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
                if (itemStateArray.size() > 3) {
                    Toast.makeText(mContext, R.string.cannot_have_more_wc, Toast.LENGTH_SHORT).show();
                    return;
                }
                iv_add_player.setImageResource(R.drawable.ic_menu_close_clear_cancel);
                itemStateArray.put(adapterPosition, true);
                mCreateTeamActivity.addPlayersToTeam("WC" + getAdapterPosition());

            } else {
                iv_add_player.setImageResource(R.drawable.ic_menu_btn_add);
                itemStateArray.put(adapterPosition, false);
                mCreateTeamActivity.deletePlayersToTeam("WC" + getAdapterPosition());

            }
        }
    }
}



