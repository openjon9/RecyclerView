package com.hehe.recyclerview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Toast;

import com.hehe.Data.data1;
import com.hehe.Data.data2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private ArrayList<data1> mData;
    private MainActivity context;
    private RecyclerView_adapter adapter;
    private ArrayList<data1> listData_1;
    private ArrayList<data1> listData_2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        recyclerView = (RecyclerView) findViewById(R.id.listview);
        mData = new ArrayList<>();
        listData_1 = new ArrayList<>();
        listData_2 = new ArrayList<>();

        init();

        adapter = new RecyclerView_adapter(mData, context,listData_1);

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);


        recyclerView.setAdapter(adapter);

    }

    private void init() {

        for (int i = 0; i < 5; i++) {
            listData_1.add(new data1(String.valueOf(i), "tag1"));
        }

        for (int i = 0; i < 10; i++) {
            listData_2.add(new data1(String.valueOf(i), "tag2"));
        }

        mData.addAll(listData_1);
        mData.addAll(listData_2);

        mData.add(0, new data1("title 1", "tag0"));
        mData.add(listData_1.size() + 1, new data1("title 2", "tag0"));

        //  mData.add(20, "this is title: 3");
        //  mData.add(60, "this is title: 4");
        // mData.add(77, "this is title: 5");


    }


}
