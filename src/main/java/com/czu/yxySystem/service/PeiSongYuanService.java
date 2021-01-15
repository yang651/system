package com.czu.yxySystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.czu.yxySystem.entity.DO.PeiSongYuanDO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Author Yxy
 * @Date 2021/1/15 15:20
 **/

public interface PeiSongYuanService extends IService<PeiSongYuanDO> {

    /**
     * @Description: 获取配送员list
     * @Param: []
     * @return: java.util.List<com.czu.yxySystem.entity.DO.PeiSongYuanDO>
     * @Author: Yxy
     * @Date: 2021/1/15 15:41
     **/
    List<PeiSongYuanDO> getList(Integer page, Integer limit, String xingMing, String chengHao, String fuZeQuYu);


    /**
     * @Description: 
     * @Param: 获取配送员的总数
     * @return: int
     * @Author: Yxy
     * @Date: 2021/1/15 15:52 
     **/
    int getCount(Integer page, Integer limit, String xingMing, String chengHao, String fuZeQuYu);
}
