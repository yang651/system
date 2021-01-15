package com.czu.yxySystem.entity.DO;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/***
* @Description: user表与group的多对多关系表DO
* @Param:
* @return:
* @Author: Yxy
* @Date: 2020/12/28
*/
@Data
@TableName("user_group")
public class UserGroupDO implements Serializable {
    private static final long serialVersionUID = 8449994934123262875L;

    @TableField("userId")
    private Integer userId;

    @TableField("groupId")
    private Integer groupId;

}
