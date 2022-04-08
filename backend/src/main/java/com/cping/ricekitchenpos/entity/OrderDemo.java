package com.cping.ricekitchenpos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDemo {
    private int id;
    private int quantity;
    private double total;
    private Date gmt_create;
    private String item;
    private int item_count;
}
