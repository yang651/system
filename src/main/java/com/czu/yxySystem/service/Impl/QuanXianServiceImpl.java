package com.czu.yxySystem.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.czu.yxySystem.entity.DO.QuanXianDO;
import com.czu.yxySystem.mapper.QuanXianMapper;
import com.czu.yxySystem.service.QuanXianService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuanXianServiceImpl extends ServiceImpl<QuanXianMapper, QuanXianDO> implements QuanXianService {

    /***
    * @Description: 获取权限list
    * @Param: [page, limit, quanXianMing]
    * @return: java.util.List<com.czu.yxySystem.entity.DO.QuanXianDO>
    * @Author: Yxy
    * @Date: 2020/12/26
    */
    @Override
    public List<QuanXianDO> getList(Integer page, Integer limit, String quanXianMing) {
        PageHelper.startPage(page, limit);
        List<QuanXianDO> list = baseMapper.getList(quanXianMing);
        return list;
    }
}
