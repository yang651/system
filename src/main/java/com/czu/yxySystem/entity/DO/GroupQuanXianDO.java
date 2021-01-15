package com.czu.yxySystem.entity.DO;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/***
* @Description: 角色和权限的多对多对应表
* @Param:
* @return:
* @Author: Yxy
* @Date: 2020/12/28
*/
@Data
@TableName("group_quanXian")
public class GroupQuanXianDO implements Serializable {
    private static final long serialVersionUID = 1483974401204185913L;

    @TableField("quanXianId")
    private Integer quanXianId;

    @TableField("groupId")
    private Integer groupId;
}
