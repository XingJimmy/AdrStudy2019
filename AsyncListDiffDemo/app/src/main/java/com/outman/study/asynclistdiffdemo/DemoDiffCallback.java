package com.outman.study.asynclistdiffdemo;

import android.support.v7.util.DiffUtil;

import java.util.List;

public class DemoDiffCallback extends DiffUtil.Callback {

    private List<DemoData> mOldList;
    private List<DemoData> mNewList;

    public DemoDiffCallback(List<DemoData> olds, List<DemoData> news) {
        this.mOldList = olds;
        this.mNewList = news;
    }

    @Override
    public int getOldListSize() {
        return mOldList == null ? 0 : mOldList.size();
    }

    @Override
    public int getNewListSize() {
        return mNewList == null ? 0 : mNewList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return mOldList.get(oldItemPosition).equals(mNewList.get(newItemPosition));
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return mOldList.get(oldItemPosition).equals(mNewList.get(newItemPosition));
    }
}
