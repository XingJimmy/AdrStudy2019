package com.outman.study.asynclistdiffdemo;

import java.util.List;

public class NormalAdapter extends CommonAdapter {

    private List<DemoData> mDatas;

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    protected DemoData getItem(int pos) {
        return mDatas.get(pos);
    }

    @Override
    public void updateData(List<DemoData> datas) {
        this.mDatas = datas;
        notifyDataSetChanged();
    }
}
