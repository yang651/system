package com.czu.yxySystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.czu.yxySystem.entity.DO.GroupDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GroupMapper extends BaseMapper<GroupDO> {
    /**
     * @Description: 获取list
     * @Param: [groupName]
     * @return: java.util.List<com.czu.yxySystem.entity.DO.QuanXianDO>
     * @Author: Yxy
     * @Date: 2020/12/26
     */
    List<GroupDO> getList(@Param("jueSeName") String jueSeName);
}
