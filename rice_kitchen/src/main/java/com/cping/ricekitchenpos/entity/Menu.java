package com.cping.ricekitchenpos.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Menu {
    private int id;
    private String code;
    private String title;
    private double price;
    private boolean state;
    private int cid;

    public Menu(String code, String title, double price, boolean state, int cid) {
        this.code = code;
        this.title = title;
        this.price = price;
        this.state = state;
        this.cid = cid;
    }
}
