package com.czu.yxySystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.czu.yxySystem.entity.DO.QuanXianDO;

import java.util.List;

public interface QuanXianService extends IService<QuanXianDO> {

    /***
    * @Description: 获取权限列表
    * @Param: [page, limit, quanXianMing]
    * @return: java.util.List<com.czu.yxySystem.entity.DO.QuanXianDO>
    * @Author: Yxy
    * @Date: 2020/12/26
    */
    List<QuanXianDO> getList(Integer page, Integer limit, String quanXianMing);
}
