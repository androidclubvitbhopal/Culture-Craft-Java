package com.example.culturecraft_java;

public class RecyclerItem {
    public String title;
    public int drawable;
    public RecyclerItem(){}

    public RecyclerItem(String title, int drawable) {
        this.title = title;
        this.drawable = drawable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }
}
