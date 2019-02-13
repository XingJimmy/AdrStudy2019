package com.outman.study.asynclistdiffdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private CommonAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView = findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.normal) {
            mAdapter = new NormalAdapter();
            mRecyclerView.setAdapter(mAdapter);

            initData();
            return true;
        }
        if (id == R.id.differ) {
            mAdapter = new AsyncListDiffAdapter();
            mRecyclerView.setAdapter(mAdapter);

            initData();
            return true;
        }
        if (id == R.id.update) {
            updateData();
            return true;
        }
        if (id == R.id.diffUtil) {
            useDiffUtil();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initData() {
        List<DemoData> datas = new ArrayList<DemoData>();
        for (int i = 0; i < 20; i++) {
            datas.add(new DemoData("Title" + i, "Content" + i));
        }
        mAdapter.updateData(datas);
    }

    private void updateData() {
        List<DemoData> datas = new ArrayList<DemoData>();
        for (int i = 0; i < 20; i++) {
            datas.add(new DemoData("Title" + i * 2, "Content" + i * 2));
        }
        mAdapter.updateData(datas);
    }

    private void useDiffUtil() {
        List<DemoData> datas = new ArrayList<DemoData>();
        for (int i = 0; i < 20; i++) {
            datas.add(new DemoData("Title" + i * 2, "Content" + i * 2));
        }
        List oldList = mAdapter.getData();
        // calculateDiff运行在主线程，如果新旧数据差别很大，耗时长，会导致ANR
        DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DemoDiffCallback(oldList, datas));
        mAdapter.setData(datas);//不能调用notifyDataSetChanged
        result.dispatchUpdatesTo(mAdapter);
    }
}
