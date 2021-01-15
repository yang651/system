package com.czu.yxySystem.entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/***
* @Description: 用户表
* @Param:
* @return:
* @Author: Yxy
* @Date: 2020/12/26
*/
@Data
@TableName("tb_user")
public class UserDO implements Serializable {

    private static final long serialVersionUID = 2280466645684556757L;
    /***
    * 用户Id
    */
    @TableId(value = "userId",type = IdType.AUTO)
    private Integer userId;

    /***
     * 用户名
     */
    @TableField("username")
    private String username;

    /***
     * 用户密码
     */
    @TableField("password")
    private String password;

}
