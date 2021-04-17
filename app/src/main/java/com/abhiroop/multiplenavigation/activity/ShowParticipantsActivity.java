package com.abhiroop.multiplenavigation.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.abhiroop.multiplenavigation.R;
import com.abhiroop.multiplenavigation.adapter.ParticipantAdapter;
import com.abhiroop.multiplenavigation.adapter.WinningBreakUpDialogAdapter;
import com.google.android.material.button.MaterialButtonToggleGroup;

public class ShowParticipantsActivity extends BaseActivity implements View.OnClickListener {

    private Button playerStatus, winningBreakUp, cancelButton ;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_participants);
        setUpToolBar();
        initView();
        setUpAlertDialog();
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.hasFixedSize();
        ParticipantAdapter adapter = new ParticipantAdapter(this);
        recyclerView.setAdapter(adapter);

    }

    private void setUpAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ShowParticipantsActivity.this);
        View dialogView = LayoutInflater.from(ShowParticipantsActivity.this).inflate(R.layout.layout_winning_break_up, null);
        builder.setView(dialogView);
        RecyclerView recyclerView = dialogView.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(ShowParticipantsActivity.this));
        recyclerView.setHasFixedSize(true);
        cancelButton = dialogView.findViewById(R.id.btn_cancel);
        WinningBreakUpDialogAdapter adapter = new WinningBreakUpDialogAdapter(ShowParticipantsActivity.this);
        recyclerView.setAdapter(adapter);
        dialog = builder.create();
        dialog.setCancelable(true);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dialog != null){
                    dialog.dismiss();
                }
            }
        });
    }

    private void setUpToolBar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void initView() {
        winningBreakUp =  findViewById(R.id.btn_winning_breakup);
        playerStatus = findViewById(R.id.btn_player_status);
        winningBreakUp.setOnClickListener(this);
        playerStatus.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.btn_winning_breakup:
               dialog.show();
            break;
            case R.id.btn_cancel:
                if(dialog != null){
                    dialog.dismiss();
                }
            case R.id.btn_player_status:
                Intent intent = new Intent(this, PlayerStatusActivity.class);
                startActivity(intent);
                break;
        }
    }
}


