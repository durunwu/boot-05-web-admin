package com.atguigu.admin.controller;

import com.atguigu.admin.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    //登陆页面
    @GetMapping(value = {"/","/login"})
    public String indexController(){
        return "login";
    }

    //首页
    @PostMapping("/login")
    public String mainTest(User user, HttpSession session, Model model){
        //return "main"; 通过/login转发到main页面，
        // 刷新当前页面/login,因为是post请求会出现重复提交主页的问题，
        // 避免重复提交这种情况使用重定向，这样每次就好刷新main页面，不会产生post提交

        if (StringUtils.hasLength(user.getUserName()) && "123456".equals(user.getPassword())){
            session.setAttribute("loginUser",user);
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","登陆失败");
            return "/login";
        }
    }

    @GetMapping("/main.html")
    public String mainHtml(HttpSession session,Model model){
        //设置拦截器
//        if (session.getAttribute("loginUser") != null){
//            return "main";
//        }else {
//            model.addAttribute("msg","请登陆账户");
//            return "login";
//        }
        return "main.html";
    }

}
