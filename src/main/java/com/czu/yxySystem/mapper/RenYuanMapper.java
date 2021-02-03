package com.czu.yxySystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.czu.yxySystem.entity.DO.RenYuanDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description TODO
 * @Author Yxy
 * @Date 2021/1/15 15:20
 **/
@Mapper
public interface RenYuanMapper extends BaseMapper<RenYuanDO> {

    /**
     * @Description: 获取配送员list
     * @Param: [xingMing, chengHao, fuZeQuYu]
     * @return: java.util.List<com.czu.yxySystem.entity.DO.PeiSongYuanDO>
     * @Author: Yxy
     * @Date: 2021/1/15 15:43
     **/
    List<RenYuanDO> getList(@Param("xingMing") String xingMing, @Param("chengHao") String chengHao, @Param("shiFouLiZhi") boolean shiFouLiZhi);

    /**
     * @Description: 获取配送员数量
     * @Param: []
     * @return: int
     * @Author: Yxy
     * @Date: 2021/1/15 15:53
     **/
    int getCount(@Param("xingMing") String xingMing, @Param("chengHao") String chengHao, @Param("shiFouLiZhi") boolean shiFouLiZhi);

}
