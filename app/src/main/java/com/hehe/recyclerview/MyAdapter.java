package com.hehe.recyclerview;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Rey on 2018/5/10.
 */

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private Context c;
    private List<String> mData;
    private List<Boolean> isClicks;
    private Random mRandom;

    public MyAdapter(Context c, List<String> mData) {
        this.c = c;
        this.mData = mData;

        isClicks = new ArrayList<>();
        for (int i = 0; i < mData.size(); i++) {
            isClicks.add(false);  //全部的資料都給false 狀態
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mylayout, null); // <-- 這樣會導致布局都靠左無法調整
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mylayout, parent, false);
        MyViewHolder MyHolder = new MyViewHolder(view);
        return MyHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.text1.setText(mData.get(position));
       // holder.liner.getLayoutParams().height = getRandomIntInRange(750, 75);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nposition = holder.getLayoutPosition();
                for (int i = 0; i < isClicks.size(); i++) {
                    isClicks.set(i, false);
                }
                isClicks.set(nposition, true);
                notifyDataSetChanged();
                Toast.makeText(c, "這是" + position + "點擊", Toast.LENGTH_SHORT).show();
            }
        });

        if (isClicks.get(position)) {
            //  holder.text1.setTextColor(Color.RED);
            //  holder.liner.setBackgroundColor(Color.YELLOW); //水波紋跟被景色衝突
        } else {
            //  holder.text1.setTextColor(Color.BLACK);
            // holder.liner.setBackgroundColor(Color.WHITE);
        }

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    protected int getRandomIntInRange(int max, int min) {
        return mRandom.nextInt((max - min) + min) + min;
    }

}

