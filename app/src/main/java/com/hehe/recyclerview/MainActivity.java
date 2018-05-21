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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter mAdapter;
    List<String> list;
    private ItemTouchHelper itemTouchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.listview);


        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }

        mAdapter = new MyAdapter(this, list);
        StaggeredGridLayoutManager layoutManager =new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL); //瀑布流
        recyclerView.setLayoutManager(layoutManager);

       // recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        recyclerView.setAdapter(mAdapter);

//        recyclerView.addOnItemTouchListener(new OnRecyclerItemClickListener(recyclerView) {
//            @Override
//            public void onItemClick(RecyclerView.ViewHolder vh) {
//
//            }
//
//            @Override
//            public void onItemLongClick(RecyclerView.ViewHolder vh) {
//                if (vh.getLayoutPosition() != 0 && vh.getLayoutPosition() != 1) { //限制前2個位置不可拖拉  但是後面可以拉到這2個位置 這是BUG
//                    itemTouchHelper.startDrag(vh);
//
//                }
//            }
//        });

        itemTouchHelper = new ItemTouchHelper(mCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

    }

    private int fromPosition;
    public int toPosition;

                                                                                //拖拉方向                                                                                          //滑動方向
    ItemTouchHelper.Callback mCallback = new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN|ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT, ItemTouchHelper.START | ItemTouchHelper.END) {

        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) { //拖動中時調用
            fromPosition = viewHolder.getAdapterPosition();
            toPosition = target.getAdapterPosition();
            mAdapter.notifyItemMoved(fromPosition, toPosition);
            Collections.swap(list, fromPosition, toPosition); //更改變動後的索引直  拖動時會不斷更改索引直
            //Toast.makeText(MainActivity.this, "移動", Toast.LENGTH_SHORT).show();
            return true;
        }

        @Override
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return super.makeMovementFlags(getDragDirs(recyclerView, viewHolder), getSwipeDirs(recyclerView, viewHolder));
        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) { //移除後呼叫 滑動效果
            int position = viewHolder.getAdapterPosition();
            list.remove(position);
            mAdapter.notifyItemRemoved(position);
            //  Toast.makeText(MainActivity.this, "onSwiped", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) { //長按 或 狀態改變時呼叫
            if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
                viewHolder.itemView.setBackgroundColor(Color.YELLOW);

            }
            super.onSelectedChanged(viewHolder, actionState);
            //  Toast.makeText(MainActivity.this, "長按", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) { //手指放開時調用
            super.clearView(recyclerView, viewHolder);
            viewHolder.itemView.setBackgroundColor(0);

            // Toast.makeText(MainActivity.this, "放開", Toast.LENGTH_SHORT).show();
        }

        @Override
        public boolean isLongPressDragEnabled() {  //拖拉是否可用

            return false;
        }

//        @Override
//        public boolean isItemViewSwipeEnabled() { //滑動是否可用
//            return super.isItemViewSwipeEnabled();
//        }
    };

}
