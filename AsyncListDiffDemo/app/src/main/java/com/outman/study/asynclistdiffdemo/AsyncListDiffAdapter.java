package com.outman.study.asynclistdiffdemo;

import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.AsyncListDiffer;
import android.support.v7.util.DiffUtil;

import java.util.List;

public class AsyncListDiffAdapter extends CommonAdapter {

    private AsyncListDiffer<DemoData> mListDiffer;

    public AsyncListDiffAdapter() {
        mListDiffer = new AsyncListDiffer<DemoData>(this, mItemCallback);
    }

    @Override
    public int getItemCount() {
        return mListDiffer.getCurrentList().size();
    }

    @Override
    public void updateData(List<DemoData> datas) {
        mListDiffer.submitList(datas);
    }

    @Override
    protected DemoData getItem(int pos) {
        return mListDiffer.getCurrentList().get(pos);
    }

    private DiffUtil.ItemCallback<DemoData> mItemCallback = new DiffUtil.ItemCallback<DemoData>() {

        @Override
        public boolean areItemsTheSame(@NonNull DemoData demoData, @NonNull DemoData t1) {
            return demoData.equals(t1);
        }

        @Override
        public boolean areContentsTheSame(@NonNull DemoData demoData, @NonNull DemoData t1) {
            return demoData.equals(t1);
        }
    };
}
