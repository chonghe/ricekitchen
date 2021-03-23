package com.cping.ricekitchenpos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private int id;
    private double price;
    private String paytype;
    private Customer customer;
    private List<OrderDetail> orderdetail;
}
