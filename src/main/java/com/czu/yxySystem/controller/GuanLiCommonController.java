package com.czu.yxySystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/***
* @Description: 管理页面跳转通用控制器
* @Param:
* @return:
* @Author: Yxy
* @Date: 2020/12/26
*/
@Controller
public class GuanLiCommonController {

    /***
    * @Description: 跳转到权限设置页面
    * @Param: []
    * @return: java.lang.String
    * @Author: Yxy
    * @Date: 2020/12/26
    */
    @GetMapping("/to_quanXianSheZhi.do")
    public String toQuanXianSheZhi() {
        return "guanLi/quanXianSheZhi";
    }

    /***
     * @Description: 跳转到权限设置添加界面
     * @Param: []
     * @return: java.lang.String
     * @Author: Yxy
     * @Date: 2020/12/26
     */
    @GetMapping("/to_quanXianSheZhi_add.do")
    public String toQuanXianSheZhiAdd(){
        return "guanLi/quanXianSheZhi_add";
    }


    /***
    * @Description: 跳转到权限设置编辑界面
    * @Param: []
    * @return: java.lang.String
    * @Author: Yxy
    * @Date: 2020/12/26
    */
    @GetMapping("/to_quanXianSheZhi_edit.do")
    public String toQuanXianSheZhiEdit(){
        return "guanLi/quanXianSheZhi_edit";
    }

    /***
    * @Description: 跳转到用户设置页面
    * @Param: []
    * @return: java.lang.String
    * @Author: Yxy
    * @Date: 2020/12/28
    */
    @GetMapping("/to_yongHuSheZhi.do")
    public String toYongHuSheZhi(){
        return "guanLi/yongHuSheZhi";
    }

    /***
     * @Description: 跳转到用户设置添加界面
     * @Param: []
     * @return: java.lang.String
     * @Author: Yxy
     * @Date: 2020/12/26
     */
    @GetMapping("/to_yongHuSheZhi_add.do")
    public String toYongHuSheZhiAdd(){
        return "guanLi/yongHuSheZhi_add";
    }


    /***
     * @Description: 跳转到用户设置编辑界面
     * @Param: []
     * @return: java.lang.String
     * @Author: Yxy
     * @Date: 2020/12/26
     */
    @GetMapping("/to_yongHuSheZhi_edit.do")
    public String toYongHuSheZhiEdit(){
        return "guanLi/yongHuSheZhi_edit";
    }

    /***
    * @Description:跳转到角色设置页面
    * @Param: []
    * @return: java.lang.String
    * @Author: Yxy
    * @Date: 2021/1/8
    */
    @GetMapping("/to_jueSeSheZhi.do")
    public String toJueSeSheZhi(){
        return "guanLi/jueSeSheZhi";
    }

    /***
     * @Description: 跳转到角色设置添加界面
     * @Param: []
     * @return: java.lang.String
     * @Author: Yxy
     * @Date: 2020/12/26
     */
    @GetMapping("/to_jueSeSheZhi_add.do")
    public String toJueSeSheZhiAdd(){
        return "guanLi/jueSeSheZhi_add";
    }

    /***
     * @Description: 跳转到角色设置编辑界面
     * @Param: []
     * @return: java.lang.String
     * @Author: Yxy
     * @Date: 2020/12/26
     */
    @GetMapping("/to_jueSeSheZhi_edit.do")
    public String toJueSeSheZhiEdit(){
        return "guanLi/jueSeSheZhi_edit";
    }

    /***
    * @Description: 跳转到统一权限管理界面
    * @Param: []
    * @return: java.lang.String
    * @Author: Yxy
    * @Date: 2021/1/8
    */
    @GetMapping("/to_tongYiQuanXianGuanLi.do")
    public String toTongYiQuanXianGuanLi(){
        return "guanLi/tongYiQuanXianGuanLi";
    }

    /**
     * @Description: 跳转到配送员信息管理页面
     * @Param: []
     * @return: java.lang.String
     * @Author: Yxy
     * @Date:  14:22
     **/
    @GetMapping("/to_renYuanGuanLi.do")
    public String toPeiSongYuanGuanLi(){
        return "guanLi/renYuanGuanLi";
    }
    
    /**
     * @Description: 跳转到人员add界面（入职）
     * @Param: []
     * @return: java.lang.String
     * @Author: Yxy
     * @Date: 2021/1/16 13:56 
     **/
    @RequestMapping("/to_renYuanAdd.do")
    public String toRenYuanAdd(){
        return "guanLi/renYuanGuanLi_add";
    }




}
