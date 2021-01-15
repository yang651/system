package com.czu.yxySystem.user;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/***
* @Description: 用户登录相关页面跳转控制器
* @Param:
* @return:
* @Author: Yxy
* @Date: 2020/12/26
*/
@Controller
public class UserCommonController {

    /***
     * @Description: 项目启动就跳转到登录页面
     * @Param: []
     * @return: java.lang.String
     * @Author: Yxy
     * @Date: 2020/12/26
     */
    @GetMapping("/to_login.do")
    public String toLogin() {
        return "login";
    }

    /***
     * @Description: 登录成功跳转到首页
     * @Param: []
     * @return: java.lang.String
     * @Author: Yxy
     * @Date: 2020/12/15
     */
    @GetMapping("/to_main.do")
    public String toMain() {
        return "index";
    }

    /***
     * @Description: 去首页
     * @Param: []
     * @return: java.lang.String
     * @Author: Yxy
     * @Date: 2020/12/26
     */
    @GetMapping("/to_shouye.do")
    public String toShouYe() {
        return "shouye";
    }


}
