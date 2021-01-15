package com.czu.yxySystem.user;


import com.czu.yxySystem.util.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/***
* @Description: 用户登录控制器
* @Param: 
* @return: 
* @Author: Yxy
* @Date: 2020/12/26
*/
@RestController
@RequestMapping("/denglu")
public class UserController {

    @RequestMapping("/yanZheng.do")
    public R DengLuYanZheng(@RequestParam("username") String username, @RequestParam("password") String password){
        return R.ok();
    }







}
