package com.abhiroop.multiplenavigation.adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.abhiroop.multiplenavigation.R;
import com.abhiroop.multiplenavigation.activity.ContestActivity;
import com.abhiroop.multiplenavigation.activity.SelectTeamToJoinActivity;
import com.abhiroop.multiplenavigation.activity.ShowParticipantsActivity;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;


public class ContestActivityAdapter extends RecyclerView.Adapter<ContestActivityAdapter.ViewHolder> implements View.OnClickListener {

    private Context mContext;

    public ContestActivityAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ContestActivityAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_card_contest, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContestActivityAdapter.ViewHolder holder, int position) {
          holder.btn_winning_breakup.setOnClickListener(this);
          holder.btn_join.setOnClickListener(this);
          holder.btn_show_participants.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.btn_winning_breakup:
                openWinningBreakUpDialog();
                break;
            case R.id.btn_join:
                Intent intent = new Intent(mContext, SelectTeamToJoinActivity.class);
                mContext.startActivity(intent);
                break;
            case R.id.btn_show_participants:
                Intent intent1 = new Intent(mContext, ShowParticipantsActivity.class);
                mContext.startActivity(intent1);
        }
    }

    private void openWinningBreakUpDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        View view =LayoutInflater.from(mContext).inflate(R.layout.layout_winning_break_up, null);
        builder.setView(view);
        RecyclerView recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setHasFixedSize(true);
        Button cancelButton = view.findViewById(R.id.btn_cancel);
        WinningBreakUpDialogAdapter adapter = new WinningBreakUpDialogAdapter(mContext);
        recyclerView.setAdapter(adapter);
        AlertDialog dialog = builder.create();
        dialog.setCancelable(true);
        dialog.show();
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dialog != null){
                    dialog.dismiss();
                }
            }
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public Button btn_winning_breakup, btn_show_participants, btn_join;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            btn_winning_breakup = itemView.findViewById(R.id.btn_winning_breakup);
            btn_show_participants = itemView.findViewById(R.id.btn_show_participants);
            btn_join = itemView.findViewById(R.id.btn_join);
        }
    }
}
