package com.example.administrator.recycleview_all;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<String> mDatas;
    private MyRecyclerAdapter recycleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView );

        initData();
        recycleAdapter= new MyRecyclerAdapter(MainActivity.this , mDatas );
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //设置布局管理器
        recyclerView.setLayoutManager(layoutManager);
        //设置为垂直布局，这也是默认的
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        //设置Adapter
        recyclerView.setAdapter(recycleAdapter);
        //设置增加或删除条目的动画
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recycleAdapter.setmOnItemClickListener(new MyRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this,mDatas.get(position),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {
        mDatas = new ArrayList<String>();
        for ( int i=0; i < 40; i++) {
            mDatas.add( "item"+i);
        }
    }


}

