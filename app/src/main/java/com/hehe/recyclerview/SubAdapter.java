package com.hehe.recyclerview;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hehe.Data.data1;

import java.util.List;

/**
 * Created by Rey on 2018/10/12.
 */

public class SubAdapter extends RecyclerView.Adapter<SubAdapter.ViewHolder> {


    List<data1> list;
    Activity context;


    public SubAdapter(List<data1> list, Activity context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View mview = LayoutInflater.from(context).inflate(R.layout.onelayout, parent, false);

        return new SubAdapter.ViewHolder(mview);
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
