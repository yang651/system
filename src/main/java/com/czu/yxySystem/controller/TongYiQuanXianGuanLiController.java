package com.czu.yxySystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.czu.yxySystem.entity.DO.*;
import com.czu.yxySystem.entity.DTO.UserDataDTO;
import com.czu.yxySystem.service.*;
import com.czu.yxySystem.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/***
* @Description: 统一权限管理控制器
* @Param:
* @return:
* @Author: Yxy
* @Date: 2021/1/13
*/
@RestController
@RequestMapping("/tongYiQuanXianGuanLi")
public class TongYiQuanXianGuanLiController {

    @Autowired
    private UserService userService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private QuanXianService quanXianService;

    @Autowired
    private UserGroupService userGroupService;

    @Autowired
    private GroupQuanXianService groupQuanXianService;


//    /***
//    * @Description: 获取所有页面加载所需数据
//    * @Param: []
//    * @return: com.czu.yxySystem.util.R
//    * @Author: Yxy
//    * @Date: 2021/1/13
//    */
//    @RequestMapping("/getAllData.do")
//    public R getAllData(){
//        List<UserDO> userList = userService.list();
//        List<GroupDO> groupSeList = groupService.list();
//        List<QuanXianDO> quanXianList = quanXianService.list();
//        return R.ok().put("userList",userList).put("groupSeList",groupSeList).put("quanXianList",quanXianList);
//    }

    /***
    * @Description: 根据userId获取当前用户所属组
    * @Param: [userId]
    * @return: com.czu.yxySystem.util.R
    * @Author: Yxy
    * @Date: 2021/1/13
    */
    @RequestMapping("/getGroupByUserId.do")
    public R getGroupByUserId(@RequestParam(value = "userId",required = false) Integer userId){
        List<UserGroupDO> list = userGroupService.list(new QueryWrapper<UserGroupDO>().eq("userId",userId));
        return R.ok().put("list",list);
    }

    /***
    * @Description: 根据groupId获取当前组拥有权限
    * @Param: [groupId]
    * @return: com.czu.yxySystem.util.R
    * @Author: Yxy
    * @Date: 2021/1/13
    */
    @RequestMapping("/getQuanXianByGroupId.do")
    public R getQuanXianByGroupId(@RequestParam(value = "groupId",required = false) Integer groupId){
        List<GroupQuanXianDO> list = groupQuanXianService.list(new QueryWrapper<GroupQuanXianDO>().eq("groupId",groupId));
        return R.ok().put("list",list);
    }

    /***
    * @Description: 给用户分配角色
    * @Param: []
    * @return: com.czu.yxySystem.util.R
    * @Author: Yxy
    * @Date: 2021/1/13
    */
    @RequestMapping("/fenPeiGroup.do")
    public R fenPeiGroup(@RequestBody UserDataDTO userDataDTO){
        Integer userId = userDataDTO.getYongHu();
        List<Integer> jueSeList = userDataDTO.getJueSeList();
        userGroupService.remove(new UpdateWrapper<UserGroupDO>().eq("userId",userId));
        for(Integer groupId:jueSeList){
            UserGroupDO userGroupDO = new UserGroupDO();
            userGroupDO.setUserId(userId);
            userGroupDO.setGroupId(groupId);
            userGroupService.save(userGroupDO);
        }
        return R.ok("修改成功！");
    }

    /***
     * @Description: 给角色分配权限
     * @Param: []
     * @return: com.czu.yxySystem.util.R
     * @Author: Yxy
     * @Date: 2021/1/13
     */
    @RequestMapping("/fenPeiQuanXian.do")
    public R fenPeiQuanXian(@RequestBody UserDataDTO userDataDTO){
        Integer groupId = userDataDTO.getJueSe();
        List<Integer> quanXianList = userDataDTO.getQuanXianList();
        groupQuanXianService.remove(new UpdateWrapper<GroupQuanXianDO>().eq("groupId",groupId));
        for(Integer quanXianId:quanXianList){
            GroupQuanXianDO groupQuanXianDO = new GroupQuanXianDO();
            groupQuanXianDO.setGroupId(groupId);
            groupQuanXianDO.setQuanXianId(quanXianId);
            groupQuanXianService.save(groupQuanXianDO);
        }
        return R.ok("修改成功！");
    }
}
