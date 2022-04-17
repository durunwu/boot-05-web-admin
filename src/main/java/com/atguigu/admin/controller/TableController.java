package com.atguigu.admin.controller;

import com.atguigu.admin.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {
    //获取table页面信息
    @GetMapping("/basic_table")
    public String basic_table(){
        return "table/basic_table";
    }

    @GetMapping("dynamic_table")
    public String dynamic_table(Model model){
        //动态遍历表格数据
        List<User> userList = Arrays.asList(new User("effect01","123456"),
                new User("effect02","123456"),
                new User("effect03","123456"),
                new User("effect04","123456"));
       model.addAttribute("userList",userList);
        return "table/dynamic_table";
    }

    @GetMapping("editable_table")
    public String editable_table(){
        return "table/editable_table";
    }

    @GetMapping("pricing_table")
    public String pricing_table(){
        return "table/pricing_table";
    }

    @GetMapping("responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }


}
