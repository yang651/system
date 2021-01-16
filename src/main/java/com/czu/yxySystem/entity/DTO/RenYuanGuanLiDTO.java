package com.czu.yxySystem.entity.DTO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Description 人员管理使用的数据传输类
 * @Author Yxy
 * @Date 2021/1/15 15:13
 **/
@Data
public class RenYuanGuanLiDTO {
    private Integer id;
    private String xingMing;
    private Integer nianLing;
    private String ruZhiRiQi;
    private String chengHao;
    private String lianXiDianHua;
    private Integer zhuangTai;
    private String xingBie;
    private Boolean shiFouLiZhi;
    private String jiLuRiQi;
}
