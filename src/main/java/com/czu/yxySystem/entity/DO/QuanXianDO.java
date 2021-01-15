package com.czu.yxySystem.entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("quanXian")
public class QuanXianDO implements Serializable {

    private static final long serialVersionUID = -6534842642163383125L;
    /***
     * 权限Id
     */
    @TableId(value = "quanXianId",type = IdType.AUTO)
    private Integer quanXianId;

    /***
     * 权限名
     */
    @TableField("quanXianName")
    private String quanXianName;

    /***
     * 权限描述
     */
    @TableField("quanXianDescript")
    private String quanXianDescript;



}
