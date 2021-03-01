package com.cping.ricekitchenpos.entity;

import java.util.List;

public class TypeMenu {
    private int id;
    private String title;
    private String path;
    private List<Menu> mList;

    public TypeMenu() {
    }

    public TypeMenu(String title, String path, List<Menu> mList) {
        this.title = title;
        this.path = path;
        this.mList = mList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<Menu> getmList() {
        return mList;
    }

    public void setmList(List<Menu> mList) {
        this.mList = mList;
    }

    @Override
    public String toString() {
        return "TypeMenu{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", path='" + path + '\'' +
                ", mList=" + mList +
                '}';
    }
}
