package com.czu.yxySystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.czu.yxySystem.entity.DO.QuanXianDO;
import com.czu.yxySystem.entity.DO.UserDO;
import com.czu.yxySystem.entity.DO.UserGroupDO;

import java.util.List;

public interface UserService extends IService<UserDO> {

    /***
    * @Description: 获取用户List
    * @Param: [page, limit, quanXianMing]
    * @return: java.util.List<com.czu.yxySystem.entity.DO.UserDO>
    * @Author: Yxy
    * @Date: 2020/12/28
    */
    List<UserDO> getList(Integer page, Integer limit, String username);

}
