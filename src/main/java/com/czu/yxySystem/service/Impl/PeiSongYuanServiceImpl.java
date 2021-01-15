package com.czu.yxySystem.service.Impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.czu.yxySystem.entity.DO.PeiSongYuanDO;
import com.czu.yxySystem.mapper.PeiSongYuanMapper;
import com.czu.yxySystem.service.PeiSongYuanService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Author Yxy
 * @Date 2021/1/15 15:21
 **/
@Service
public class PeiSongYuanServiceImpl extends ServiceImpl<PeiSongYuanMapper, PeiSongYuanDO> implements PeiSongYuanService {
    /**
     * @Description: 获取配送员list
     * @Param: []
     * @return: java.util.List<com.czu.yxySystem.entity.DO.PeiSongYuanDO>
     * @Author: Yxy
     * @Date: 2021/1/15 15:41
     **/
    @Override
    public List<PeiSongYuanDO> getList(Integer page, Integer limit, String xingMing, String chengHao, String fuZeQuYu) {
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
