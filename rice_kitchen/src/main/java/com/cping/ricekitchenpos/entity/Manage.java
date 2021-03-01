package com.cping.ricekitchenpos.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@ToString
public class Manage {
    private int id;
    private String title;
    private String path;
    private List<Category> sList;

    public Manage(String title, String path, List<Category> sList) {
        this.title = title;
        this.path = path;
        this.sList = sList;
    }
}
