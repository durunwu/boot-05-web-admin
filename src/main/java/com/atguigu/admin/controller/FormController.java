package com.atguigu.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@Slf4j
public class FormController {

    //访问 form_layouts页面
    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "form/form_layouts";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {
        log.info("上传的信息：email={},username={},headerImg={},photos={}",
                email,username,headerImg.getSize(),photos.length);//getSize()获取上传图像的大小,length查看photos数组的长度，查看上传了几个文件

       //上传头像（单个照片）
        if (!headerImg.isEmpty()){ //如果文件不为空，就上传
            //获取文件初始名
            String originalFilename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("C:\\JavaSoftware\\atguigu\\SpringBoot\\File\\headerImg\\" + originalFilename));
        }

        //上传一组照片
        for (MultipartFile multipartFile : photos){
            if (!multipartFile.isEmpty()){
                String originalFilename = multipartFile.getOriginalFilename();
                //文件夹后要加双 \\
                multipartFile.transferTo(new File("C:\\JavaSoftware\\atguigu\\SpringBoot\\File\\photos\\" + originalFilename));
            }
        }

        //上传成功返回主页
        return "main";

    }




}
