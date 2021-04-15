package com.abhiroop.multiplenavigation.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.abhiroop.multiplenavigation.R;
import com.abhiroop.multiplenavigation.adapter.ContestActivityAdapter;
import com.abhiroop.multiplenavigation.adapter.JoinContestAdapter;

public class ContestActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contest);
        setUpToolBar();
        initView();
    }

    private void setUpToolBar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    private void initView(){
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        ContestActivityAdapter adapter = new ContestActivityAdapter(this);
        recyclerView.setAdapter(adapter);
    }
}