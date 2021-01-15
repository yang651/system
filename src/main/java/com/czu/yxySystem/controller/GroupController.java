package com.czu.yxySystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.czu.yxySystem.entity.DO.GroupDO;
import com.czu.yxySystem.service.GroupService;
import com.czu.yxySystem.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
* @Description: 角色实体控制器
* @Param:
* @return:
* @Author: Yxy
* @Date: 2021/1/8
*/
@RestController
@RequestMapping("/jueSeSheZhi")
public class GroupController {
    @Autowired
    private GroupService jueSeService;

    /***
     * @Description: 获取角色列表
     * @Param: []
     * @return: com.czu.yxySystem.util.R
     * @Author: Yxy
     * @Date: 2020/12/26
     */
    @RequestMapping("/list.do")
    public R list(Integer page, Integer limit
            , @RequestParam(value = "jueSeName",required = false) String jueSeName){
        List<GroupDO> list = jueSeService.getList(page, limit, jueSeName);
        int count;
        if(jueSeName != null && !"".equals(jueSeName) ){
            count = jueSeService.count(new QueryWrapper<GroupDO>().like("groupName",jueSeName));
        }else {
            count = jueSeService.count();
        }
        return R.ok().put("list",list).put("count",count);
    }

    /***
     * @Description: 添加角色
     * @Param: []
     * @return: com.czu.yxySystem.util.R
     * @Author: Yxy
     * @Date: 2020/12/26
     */
    @PostMapping("/add.do")
    public R add(@RequestBody GroupDO groupDO) {
        GroupDO jueSe= jueSeService.getOne(new QueryWrapper<GroupDO>().eq("groupName",groupDO.getGroupName()));
        if (jueSe != null) {
            return R.error(1000, "角色【" + jueSe.getGroupName() + "】已存在");
        }
        //保存
        boolean save = jueSeService.save(groupDO);
        if (save) {
            return R.ok("角色添加成功");
        }
        return R.error(500, "角色添加失败");
    }

    /***
     * @Description: 编辑角色
     * @Param: []
     * @return: com.czu.yxySystem.util.R
     * @Author: Yxy
     * @Date: 2020/12/26
     */
    @PostMapping("/edit.do")
    public R edit(@RequestBody GroupDO groupDO) {
        GroupDO jueSe= jueSeService.getOne(new QueryWrapper<GroupDO>().eq("groupName",groupDO.getGroupName()));
        if (jueSe != null) {
            if(!jueSe.getGroupId().equals(groupDO.getGroupId())){
                return R.error(1000, "角色【" + jueSe.getGroupName() + "】已存在");
            }
        }
        boolean update = jueSeService.update(groupDO, new QueryWrapper<GroupDO>().eq("groupId", groupDO.getGroupId()));
        if (update) {
            return R.ok("角色编辑成功");
        }
        return R.error(500, "角色编辑失败");
    }

    /***
     * @Description: 删除角色
     * @Param: []
     * @return: com.czu.yxySystem.util.R
     * @Author: Yxy
     * @Date: 2020/12/26
     */
    @PostMapping("/delete.do")
    public R delete(@RequestBody GroupDO groupDO) {
        boolean remove = jueSeService.remove(new QueryWrapper<GroupDO>().eq("groupId", groupDO.getGroupId()));
        if (remove) {
            return R.ok("删除成功");
        }
        return R.error(500, "删除失败");
    }

    /***
     * @Description: 批量删除角色
     * @Param: []
     * @return: com.czu.yxySystem.util.R
     * @Author: Yxy
     * @Date: 2020/12/26
     */
    @PostMapping("/batchDelete.do")
    public R batchDelete(@RequestParam("itemNames[]") List<String> itemNameList) {
        for (String itemName : itemNameList) {
            boolean remove = jueSeService.remove(new QueryWrapper<GroupDO>().eq("groupName", itemName));
            if(!remove){
                return R.ok("批量删除失败，请联系管理员！");
            }
        }
        return R.ok("批量删除成功");
    }

}
