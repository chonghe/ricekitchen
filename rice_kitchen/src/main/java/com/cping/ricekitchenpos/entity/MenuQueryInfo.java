package com.cping.ricekitchenpos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


public class MenuQueryInfo {
    private String query;
    private int pageNum=1;
    private int pageSize=1;

    public MenuQueryInfo() {
    }

    public MenuQueryInfo(String query, int pageNum, int pageSize) {
        this.query = query;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "MenuQueryInfo{" +
                "query='" + query + '\'' +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}

