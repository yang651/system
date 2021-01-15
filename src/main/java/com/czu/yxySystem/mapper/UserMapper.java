package com.czu.yxySystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.czu.yxySystem.entity.DO.UserDO;
import com.czu.yxySystem.entity.DO.UserGroupDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<UserDO> {

    /***
    * @Description: 获取list
    * @Param: [username]
    * @return: java.util.List<com.czu.yxySystem.entity.DO.UserDO>
    * @Author: Yxy
    * @Date: 2020/12/28
    */
    List<UserDO> getList(@Param("username") String username);

}
