package com.czu.yxySystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.czu.yxySystem.entity.DO.RenYuanDO;

import java.util.List;

/**
 * @Description TODO
 * @Author Yxy
 * @Date 2021/1/15 15:20
 **/

public interface RenYuanService extends IService<RenYuanDO> {

    /**
     * @Description: 获取配送员list
     * @Param: []
     * @return: java.util.List<com.czu.yxySystem.entity.DO.PeiSongYuanDO>
     * @Author: Yxy
     * @Date: 2021/1/15 15:41
     **/
    List<RenYuanDO> getList(Integer page, Integer limit, String xingMing, String chengHao, boolean shiFouLiZhi);


    /**
     * @Description: 
     * @Param: 获取配送员的总数
     * @return: int
     * @Author: Yxy
     * @Date: 2021/1/15 15:52 
     **/
    int getCount(Integer page, Integer limit, String xingMing, String chengHao, boolean shiFouLiZhi);
}
