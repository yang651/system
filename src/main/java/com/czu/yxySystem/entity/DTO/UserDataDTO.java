package com.czu.yxySystem.entity.DTO;

import lombok.Data;

import java.util.List;


/**
 * @Description 给用户分配角色 和 给角色分配权限 使用的实体传输类
 * @Author Yxy
 * @Date 2021/1/14 17:05
 **/
@Data
public class UserDataDTO {

    private Integer yongHu;

    private List<Integer> jueSeList;

    private Integer jueSe;

    private List<Integer> quanXianList;
}
