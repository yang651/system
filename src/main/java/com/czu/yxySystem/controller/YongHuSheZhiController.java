package com.czu.yxySystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.czu.yxySystem.entity.DO.QuanXianDO;
import com.czu.yxySystem.entity.DO.UserDO;
import com.czu.yxySystem.service.QuanXianService;
import com.czu.yxySystem.service.UserService;
import com.czu.yxySystem.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
* @Description: 权限管理页面相关Controller
* @Param:
* @return:
* @Author: Yxy
* @Date: 2020/12/26
*/
@RestController
@RequestMapping("/yongHuSheZhi")
public class YongHuSheZhiController {


    @Autowired
    private UserService userService;

    /***
    * @Description: 获取用户列表
    * @Param: []
    * @return: com.czu.yxySystem.util.R
    * @Author: Yxy
    * @Date: 2020/12/26
    */
    @RequestMapping("/list.do")
    public R list(Integer page, Integer limit
            ,@RequestParam(value = "username",required = false) String username){
        List<UserDO> list = userService.getList(page, limit, username);
        int count;
        if(username != null && !"".equals(username)){
            count = userService.count(new QueryWrapper<UserDO>().like("username",username));
        }else {
            count = userService.count();
        }
        return R.ok().put("list",list).put("count",count);
    }

    /***
     * @Description: 添加用户
     * @Param: []
     * @return: com.czu.yxySystem.util.R
     * @Author: Yxy
     * @Date: 2020/12/26
     */
    @PostMapping("/add.do")
    public R add(@RequestBody UserDO userDO) {
        UserDO user= userService.getOne(new QueryWrapper<UserDO>().eq("username",userDO.getUsername()));
        if (user != null) {
            return R.error(1000, "用户【" + user.getUsername() + "】已存在");
        }
        //保存
        boolean save = userService.save(userDO);
        if (save) {
            return R.ok("用户添加成功");
        }
        return R.error(500, "用户添加失败");
    }

    /***
     * @Description: 编辑用户
     * @Param: []
     * @return: com.czu.yxySystem.util.R
     * @Author: Yxy
     * @Date: 2020/12/26
     */
    @PostMapping("/edit.do")
    public R edit(@RequestBody UserDO userDO) {
        UserDO user= userService.getOne(new QueryWrapper<UserDO>().eq("username",userDO.getUsername()));
        if (user != null) {
            if(!user.getUserId().equals(userDO.getUserId())){
                return R.error(1000, "用户【" + user.getUsername() + "】已存在");
            }
        }
        boolean update = userService.update(userDO, new QueryWrapper<UserDO>().eq("userId", userDO.getUserId()));
        if (update) {
            return R.ok("权限编辑成功");
        }
        return R.error(500, "权限编辑失败");
    }

    /***
     * @Description: 删除用户
     * @Param: []
     * @return: com.czu.yxySystem.util.R
     * @Author: Yxy
     * @Date: 2020/12/26
     */
    @PostMapping("/delete.do")
    public R delete(@RequestBody UserDO userDO) {
        boolean remove = userService.remove(new QueryWrapper<UserDO>().eq("userId", userDO.getUserId()));
        if (remove) {
            return R.ok("删除成功");
        }
        return R.error(500, "删除失败");
    }

    /***
     * @Description: 批量删除用户
     * @Param: []
     * @return: com.czu.yxySystem.util.R
     * @Author: Yxy
     * @Date: 2020/12/26
     */
    @PostMapping("/batchDelete.do")
    public R batchDelete(@RequestParam("itemNames[]") List<String> itemNameList) {
        for (String itemName : itemNameList) {
            boolean remove = userService.remove(new QueryWrapper<UserDO>().eq("username", itemName));
            if(!remove){
                return R.ok("批量删除失败，请联系管理员！");
            }
        }
        return R.ok("批量删除成功");
    }



}
