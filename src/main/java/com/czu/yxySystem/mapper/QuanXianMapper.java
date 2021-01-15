package com.czu.yxySystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.czu.yxySystem.entity.DO.QuanXianDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface QuanXianMapper extends BaseMapper<QuanXianDO> {

    /**
    * @Description: 获取list
    * @Param: [quanXianMing]
    * @return: java.util.List<com.czu.yxySystem.entity.DO.QuanXianDO>
    * @Author: Yxy
    * @Date: 2020/12/26
    */
    List<QuanXianDO> getList(@Param("quanXianMing") String quanXianMing);

}
