package com.example.recyclerviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecitationActivity extends AppCompatActivity {

    RecyclerView recycleview;
    QDH data = new QDH();
    ArrayList<ListModel> list = new ArrayList<>();
    String Req;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english);
        recycleview = findViewById(R.id.ERV);
        Intent intent = getIntent();
        Req= intent.getStringExtra("required");
        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerViewAdapterEnglish RVadapter = new RecyclerViewAdapterEnglish(Req);
        recycleview.setAdapter(RVadapter);
//      recycleview.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
//        recycleview.setLayoutManager(new LinearLayoutManager(this));
        recycleview.setLayoutManager(new GridLayoutManager(this, 3));

        String[] data2 = data.getEnglishSurahNames();
        for (int i = 0; i < data2.length; i++) {
            int j = i + 1;
            list.add(new ListModel(data2[i], j));
        }
        RVadapter.setData(list);

    }
}