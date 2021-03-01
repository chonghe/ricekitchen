package com.cping.ricekitchenpos.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class User {
    private int id;
    private String username;
    private String password;
    private String role;
    private boolean state;

    public User(String username, String password, String role, boolean state) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.state = state;
    }
}
