package com.cping.ricekitchen.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author cping
 * @since 2021-03-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Orderdetail对象", description="")
public class Orderdetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer mid;

    private Integer oid;

    private Integer count;


}