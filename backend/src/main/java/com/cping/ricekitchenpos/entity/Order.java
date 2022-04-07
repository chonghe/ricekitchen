package com.cping.ricekitchenpos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private int id;
    private int quantity;
    private double total;
    private Date gmt_create;
    private List orderList;
}
