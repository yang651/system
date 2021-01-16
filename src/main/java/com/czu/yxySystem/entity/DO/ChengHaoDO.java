package com.czu.yxySystem.entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author Yxy
 * @Date 2021/1/16 13:59
 **/
@Data
@TableName("chengHao")
public class ChengHaoDO implements Serializable {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField("chengHao")
    private String chengHao;

    @TableField("jiBie")
    private String jiBie;
}
