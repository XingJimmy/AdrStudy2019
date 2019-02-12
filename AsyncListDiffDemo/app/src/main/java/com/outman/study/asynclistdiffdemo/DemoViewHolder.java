package com.outman.study.asynclistdiffdemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class DemoViewHolder extends RecyclerView.ViewHolder {

    private TextView mTxTitle;
    private TextView mTxContent;

    public DemoViewHolder(@NonNull View itemView) {
        super(itemView);
        mTxTitle = itemView.findViewById(R.id.title);
        mTxContent = itemView.findViewById(R.id.content);
    }

    public void setData(DemoData data) {
        mTxTitle.setText(data.title);
        mTxContent.setText(data.content);
    }
}
