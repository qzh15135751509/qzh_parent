package com.dj.ssm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dj.ssm.pojo.ResultModel;
import com.dj.ssm.pojo.SsmpUser;
import com.dj.ssm.service.SsmpUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/user/")
public class SsmpUserPageController {
    
    public void bb(){
        System.out.println(11);
    }

    @Autowired
    private SsmpUserService ssmpUserService;

    @RequestMapping("toShow")
    public String toShow(){
        return "user/show";
    }
    @RequestMapping("toUpdate")
    public String toUpdate(Integer id, Model model){
        SsmpUser userId = ssmpUserService.getById(id);
        model.addAttribute("user", userId);
        return "user/update";
    }

    @RequestMapping("toAdd")
    public String toAdd(){
        return "user/add";
    }

    @RequestMapping("toFormTest")
    public String toFormTest(){
        return "user/form_test";
    }
}
