package com.czu.yxySystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.czu.yxySystem.entity.DO.QuanXianDO;
import com.czu.yxySystem.entity.DO.UserDO;
import com.czu.yxySystem.service.QuanXianService;
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
@RequestMapping("/quanXianSheZhi")
public class QuanXianSheZhiController {


    @Autowired
    private QuanXianService quanXianService;

    /***
    * @Description: 获取权限列表
    * @Param: []
    * @return: com.czu.yxySystem.util.R
    * @Author: Yxy
    * @Date: 2020/12/26
    */
    @RequestMapping("/list.do")
    public R list(Integer page, Integer limit
            ,@RequestParam(value = "quanXianName",required = false) String quanXianMing){
        List<QuanXianDO> list = quanXianService.getList(page, limit, quanXianMing);
        int count;
        if(quanXianMing != null && !"".equals(quanXianMing) ){
            count = quanXianService.count(new QueryWrapper<QuanXianDO>().like("quanXianName",quanXianMing));
        }else {
            count = quanXianService.count();
        }
        return R.ok().put("list",list).put("count",count);
    }

    /***
     * @Description: 添加权限
     * @Param: []
     * @return: com.czu.yxySystem.util.R
     * @Author: Yxy
     * @Date: 2020/12/26
     */
    @PostMapping("/add.do")
    public R add(@RequestBody QuanXianDO quanXianDO) {
        QuanXianDO quanXian= quanXianService.getOne(new QueryWrapper<QuanXianDO>().eq("quanXianName",quanXianDO.getQuanXianName()));
        if (quanXian != null) {
            return R.error(1000, "权限【" + quanXian.getQuanXianName() + "】已存在");
        }
        //保存
        boolean save = quanXianService.save(quanXianDO);
        if (save) {
            return R.ok("权限添加成功");
        }
        return R.error(500, "权限添加失败");
    }

    /***
     * @Description: 编辑权限
     * @Param: []
     * @return: com.czu.yxySystem.util.R
     * @Author: Yxy
     * @Date: 2020/12/26
     */
    @PostMapping("/edit.do")
    public R edit(@RequestBody QuanXianDO quanXianDO) {
        QuanXianDO quanXian= quanXianService.getOne(new QueryWrapper<QuanXianDO>().eq("quanXianName",quanXianDO.getQuanXianName()));
        if (quanXian != null) {
            if(!quanXian.getQuanXianId().equals(quanXianDO.getQuanXianId())){
                return R.error(1000, "权限【" + quanXian.getQuanXianName() + "】已存在");
            }
        }
        boolean update = quanXianService.update(quanXianDO, new QueryWrapper<QuanXianDO>().eq("quanXianId", quanXianDO.getQuanXianId()));
        if (update) {
            return R.ok("权限编辑成功");
        }
        return R.error(500, "权限编辑失败");
    }

    /***
     * @Description: 删除权限
     * @Param: []
     * @return: com.czu.yxySystem.util.R
     * @Author: Yxy
     * @Date: 2020/12/26
     */
    @PostMapping("/delete.do")
    public R delete(@RequestBody QuanXianDO quanXianDO) {
        boolean remove = quanXianService.remove(new QueryWrapper<QuanXianDO>().eq("quanXianId", quanXianDO.getQuanXianId()));
        if (remove) {
            return R.ok("删除成功");
        }
        return R.error(500, "删除失败");
    }

    /***
     * @Description: 批量删除权限
     * @Param: []
     * @return: com.czu.yxySystem.util.R
     * @Author: Yxy
     * @Date: 2020/12/26
     */
    @PostMapping("/batchDelete.do")
    public R batchDelete(@RequestParam("itemNames[]") List<String> itemNameList) {
        for (String itemName : itemNameList) {
            boolean remove = quanXianService.remove(new QueryWrapper<QuanXianDO>().eq("quanXianId", itemName));
            if(!remove){
                return R.ok("批量删除失败，请联系管理员！");
            }
        }
        return R.ok("批量删除成功");
    }



}
