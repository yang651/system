package com.czu.yxySystem.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.czu.yxySystem.entity.DO.RenYuanDO;
import com.czu.yxySystem.mapper.RenYuanMapper;
import com.czu.yxySystem.service.RenYuanService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Author Yxy
 * @Date 2021/1/15 15:21
 **/
@Service
public class RenYuanServiceImpl extends ServiceImpl<RenYuanMapper, RenYuanDO> implements RenYuanService {
    /**
     * @Description: 获取配送员list
     * @Param: []
     * @return: java.util.List<com.czu.yxySystem.entity.DO.RenYuanDO>
     * @Author: Yxy
     * @Date: 2021/1/15 15:41
     **/
    @Override
    public List<RenYuanDO> getList(Integer page, Integer limit, String xingMing, String chengHao, String fuZeQuYu) {
        PageHelper.startPage(page, limit);
        return baseMapper.getList(xingMing,chengHao,fuZeQuYu);
    }

    /**
     * @Description: 获取配送员数量
     * @Param: [page, limit, xingMing, chengHao, fuZeQuYu]
     * @return: int
     * @Author: Yxy
     * @Date: 2021/1/15 15:53
     **/
    @Override
    public int getCount(Integer page, Integer limit, String xingMing, String chengHao, String fuZeQuYu) {
        return baseMapper.getCount(xingMing,chengHao,fuZeQuYu);
    }
}
