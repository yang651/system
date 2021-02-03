package com.czu.yxySystem.user;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.czu.yxySystem.entity.DO.UserDO;
import com.czu.yxySystem.service.UserService;
import com.czu.yxySystem.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

    @Autowired
    private UserService userService;

    @RequestMapping("/yanZheng.do")
    public R DengLuYanZheng(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request){
        UserDO userDO = userService.getOne(new QueryWrapper<UserDO>().eq("username", username).eq("password", password));
        HttpSession session = request.getSession();
        if(userDO == null){
            session.setAttribute("LOGIN_USER","未指定当前用户");
            return R.error(500,"账号或密码错误!");
        }
        session.setAttribute("LOGIN_USER",userDO.getUsername());
        return R.ok();
    }

    @PostMapping("/logout.do")
    public R logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("LOGIN_USER");
        return R.ok("正在退出...");
    }









}
