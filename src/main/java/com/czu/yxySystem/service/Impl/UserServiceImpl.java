package com.czu.yxySystem.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.czu.yxySystem.entity.DO.UserDO;
import com.czu.yxySystem.entity.DO.UserGroupDO;
import com.czu.yxySystem.mapper.UserMapper;
import com.czu.yxySystem.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

    /***
     * @Description: 获取用户List
     * @Param: [page, limit, quanXianMing]
     * @return: java.util.List<com.czu.yxySystem.entity.DO.UserDO>
     * @Author: Yxy
     * @Date: 2020/12/28
     */
    @Override
    public List<UserDO> getList(Integer page, Integer limit, String username) {
        PageHelper.startPage(page, limit);
        return baseMapper.getList(username);
    }


}
