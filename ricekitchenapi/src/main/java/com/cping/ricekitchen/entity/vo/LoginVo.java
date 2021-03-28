package com.cping.ricekitchen.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LoginVo {
    @ApiModelProperty(value = "username")
    private String username;
    @ApiModelProperty(value = "password")
    private String password;
}
