package com.hehe.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Rey on 2018/5/10.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {

    LinearLayout liner;
    TextView text1;

    public MyViewHolder(View itemView) {
        super(itemView);
        text1 = itemView.findViewById(R.id.text1);
        liner = itemView.findViewById(R.id.liner);
    }

}
