package com.outman.study.asynclistdiffdemo;

import android.text.TextUtils;

public class DemoData {

    public String title;
    public String content;

    public DemoData(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof DemoData) {
            DemoData data = (DemoData)obj;
            if (TextUtils.equals(data.title, title) && TextUtils.equals(data.content, content)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return title.hashCode() * 17 + content.hashCode();
    }
}
