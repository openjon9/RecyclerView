package com.hehe.recyclerview;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hehe.Data.data1;
import com.hehe.Data.data2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rey on 2018/10/12.
 */

public class RecyclerView_adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private ArrayList<data2> listData_2;
    private ArrayList<data1> listData_1;

    private RecyclerView listview_sub;
    List<data1> mData;
    Activity context;

    private static final int TYPE_0 = 0;
    private static final int TYPE_1 = 1;
    private static final int TYPE_2 = 2;

    public RecyclerView_adapter(List<data1> mData, Activity context, ArrayList<data1> listData_1) {
        this.mData = mData;
        this.context = context;
        this.listData_1 = listData_1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // View mview = LayoutInflater.from(context).inflate(R.layout.mylayout, parent, false);
        LayoutInflater mInflater = LayoutInflater.from(context);

        switch (viewType) {
            case TYPE_0:
                View mview = mInflater.from(context).inflate(R.layout.titlelayout_1, parent, false);
                GroupViewHolder vhfroup = new GroupViewHolder(mview);
                return vhfroup;

            case TYPE_1:
                View mview2 = mInflater.from(context).inflate(R.layout.onelayout, parent, false);
                subHolder vhsub = new subHolder(mview2);
                return vhsub;

            case TYPE_2:

                View mview3 = mInflater.from(context).inflate(R.layout.twolayout, parent, false);
                subHolder2 vhsub2 = new subHolder2(mview3);
                return vhsub2;
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {


        switch (holder.getItemViewType()) {
            case TYPE_0:
                GroupViewHolder groupViewHolder = (GroupViewHolder) holder;
                groupViewHolder.text.setText(mData.get(position).getText());

                groupViewHolder.img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (mData.get(position).getText().equals("title 1")) {
                            mData.add(listData_1.size()+1,new data1("123", "tag1"));
                        } else {
                            mData.add(mData.size(),new data1("456789", "tag2"));
                        }
                        notifyDataSetChanged();
                    }
                });


                break;

            case TYPE_1:
                subHolder subHolderiewHolder = (subHolder) holder;
                subHolderiewHolder.text.setText(mData.get(position).getText());

                break;

            case TYPE_2:

                subHolder2 subHolderiewHolder2 = (subHolder2) holder;
                subHolderiewHolder2.text1.setText(mData.get(position).getText());
                subHolderiewHolder2.text2.setText(mData.get(position).getText());

                break;
        }

    }

    @Override
    public int getItemViewType(int position) {
        int viewType;

        if (mData.get(position).getTag().equals("tag0")) {
            viewType = TYPE_0;
        } else if (mData.get(position).getTag().equals("tag1")) {
            viewType = TYPE_1;
        } else if (mData.get(position).getTag().equals("tag2")) {
            viewType = TYPE_2;
        } else {
            viewType = -1;
        }
        return viewType;

    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class GroupViewHolder extends RecyclerView.ViewHolder {

        TextView text;
        ImageView img;

        public GroupViewHolder(View itemView) {
            super(itemView);

            text = (TextView) itemView.findViewById(R.id.text);
            img = (ImageView) itemView.findViewById(R.id.img);
        }
    }


    public class subHolder extends RecyclerView.ViewHolder {

        TextView text;

        public subHolder(View itemView) {
            super(itemView);

            text = (TextView) itemView.findViewById(R.id.text);

        }
    }

    public class subHolder2 extends RecyclerView.ViewHolder {

        TextView text1;
        TextView text2;

        public subHolder2(View itemView) {
            super(itemView);
            text1 = (TextView) itemView.findViewById(R.id.text1);
            text2 = (TextView) itemView.findViewById(R.id.text2);
        }
    }


}
