package com.example.recyclerviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class RecitationActivity extends AppCompatActivity {

    RecyclerView recycleview;
    GivenData data = new GivenData();
    ArrayList<ListModel> list = new ArrayList<>();
    String Req;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recitation);
        recycleview = findViewById(R.id.ERV);
        Intent intent = getIntent();
        Req= intent.getStringExtra("required");
        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerAdapterRecitation RVadapter = new RecyclerAdapterRecitation(Req);
        recycleview.setAdapter(RVadapter);
//      recycleview.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
//        recycleview.setLayoutManager(new LinearLayoutManager(this));
        recycleview.setLayoutManager(new GridLayoutManager(this, 3));


        ArrayList<String> data= new ArrayList<>();
        GivenData givenData = new GivenData();

        for (String item: givenData.englishSurahNames)
        {
            data.add(item);
        }
        RVadapter.setData(list);

    }
}