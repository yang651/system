package com.czu.yxySystem.entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/***
* @Description: 用户组实体类
* @Param:
* @return:
* @Author: Yxy
* @Date: 2020/12/26
*/
@Data
@TableName("tb_group")
public class GroupDO implements Serializable {
    private static final long serialVersionUID = -4880361562335368996L;

    /***
     * 用户组Id
     */
    @TableId(value = "groupId",type = IdType.AUTO)
    private Integer groupId;

    /***
     * 用户组描述
     */
    @TableField("groupDescript")
    private String groupDescript;


    /***
     * 用户组名
     */
    @TableField("groupName")
    private String groupName;

}
