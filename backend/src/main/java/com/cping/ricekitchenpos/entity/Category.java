package com.cping.ricekitchenpos.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Category {
    private int id;
    private String title;
    private String path;

    public Category(String title, String path) {
        this.title = title;
        this.path = path;
    }
}
