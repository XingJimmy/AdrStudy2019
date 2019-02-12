package com.outman.study.asynclistdiffdemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public abstract class CommonAdapter extends RecyclerView.Adapter<DemoViewHolder> {

    @NonNull
    @Override
    public DemoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View root = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycler, null);
        return new DemoViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull DemoViewHolder demoViewHolder, int i) {
        DemoData data = getItem(i);
        demoViewHolder.setData(data);
        Log.d("AsyncListDiffDemo", "AsyncListDiffDemo onBindViewHolder title " + data.title);
    }

    protected abstract DemoData getItem(int pos);

    public abstract void updateData(List<DemoData> datas);
}
