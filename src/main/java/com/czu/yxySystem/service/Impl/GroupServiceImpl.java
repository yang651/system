package com.czu.yxySystem.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.czu.yxySystem.entity.DO.GroupDO;
import com.czu.yxySystem.mapper.GroupMapper;
import com.czu.yxySystem.service.GroupService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl extends ServiceImpl<GroupMapper, GroupDO> implements GroupService {
    /***
     * @Description: 获取角色list
     * @Param: [page, limit, quanXianMing]
     * @return: java.util.List<com.czu.yxySystem.entity.DO.QuanXianDO>
     * @Author: Yxy
     * @Date: 2020/12/26
     */
    @Override
    public List<GroupDO> getList(Integer page, Integer limit, String jueSeName) {
        PageHelper.startPage(page, limit);
        List<GroupDO> list = baseMapper.getList(jueSeName);
        return list;
    }
}
