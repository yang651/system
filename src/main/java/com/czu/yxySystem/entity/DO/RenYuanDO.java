package com.czu.yxySystem.entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Description 配送员信息DO
 * @Author Yxy
 * @Date 2021/1/15 15:13
 **/
@Data
@TableName("renYuan")
public class RenYuanDO {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField("xingMing")
    private String xingMing;

    @TableField("nianLing")
    private Integer nianLing;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField("ruZhiRiQi")
    private Date ruZhiRiQi;

    @TableField("chengHao")
    private String chengHao;

    @TableField("lianXiDianHua")
    private String lianXiDianHua;

    @TableField("zhuangTai")
    private Integer zhuangTai;

    @TableField("xingBie")
    private String xingBie;

    @TableField("shiFouLiZhi")
    private Boolean shiFouLiZhi;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField("jiLuRiQi")
    private Date jiLuRiQi;
}
