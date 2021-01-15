package com.czu.yxySystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.czu.yxySystem.entity.DO.GroupDO;

import java.util.List;

public interface GroupService extends IService<GroupDO> {

    /***
     * @Description: 获取角色列表
     * @Param: [page, limit, quanXianMing]
     * @return: java.util.List<com.czu.yxySystem.entity.DO.QuanXianDO>
     * @Author: Yxy
     * @Date: 2020/12/26
     */
    List<GroupDO> getList(Integer page, Integer limit, String jueSeName);

}
