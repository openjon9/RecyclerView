package com.hehe.recyclerview;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hehe.Data.data2;

import java.util.List;

/**
 * Created by Rey on 2018/10/12.
 */

public class SubAdapter_2 extends RecyclerView.Adapter<SubAdapter_2.ViewHolder> {

    List<data2> list;
    Activity context;

    public SubAdapter_2(List<data2> list, Activity context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View mview = LayoutInflater.from(context).inflate(R.layout.twolayout, parent, false);

        return new SubAdapter_2.ViewHolder(mview);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.text.setText(list.get(position).getText());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView text;

        public ViewHolder(View itemView) {
            super(itemView);

            text = (TextView) itemView.findViewById(R.id.text);
        }
    }

}
