package com.czu.yxySystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.czu.yxySystem.entity.DO.UserGroupDO;
import org.apache.ibatis.annotations.Mapper;

/***
* @Description: 用户和用户组映射表Mapper
* @Param:
* @return:
* @Author: Yxy
* @Date: 2021/1/13
*/
@Mapper
public interface UserGroupMapper extends BaseMapper<UserGroupDO> {
}
