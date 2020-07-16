package com.dj.ssm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dj.ssm.pojo.ResultModel;
import com.dj.ssm.pojo.SsmpUser;
import com.dj.ssm.pojo.UserQuery;
import com.dj.ssm.service.SsmpUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user/")
public class SsmpUserController {
    @Autowired
    private SsmpUserService ssmpUserService;


    @RequestMapping("show")
    public ResultModel show(UserQuery userQuery){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            QueryWrapper<SsmpUser> queryWrapper = new QueryWrapper<>();
            if (!StringUtils.isEmpty(userQuery.getUserName())){
                queryWrapper.like("user_name", userQuery.getUserName());
            }
            if (userQuery.getStartAge() != null){
                queryWrapper.ge("user_age", userQuery.getStartAge());
            }
            if (userQuery.getEndAge() != null){
                queryWrapper.le("user_age", userQuery.getEndAge());
            }
            if (userQuery.getUserSex() != null && !userQuery.getUserSex().isEmpty()){
                queryWrapper.in("user_sex", userQuery.getUserSex());
            }
            IPage<SsmpUser> page = new Page<>(userQuery.getPageNo(), userQuery.getPageSize());
            IPage<SsmpUser> pageInfo = ssmpUserService.page(page, queryWrapper);
            map.put("userList",pageInfo.getRecords());
            map.put("pages",pageInfo.getPages());
            return new ResultModel().success(map);
        }catch (Exception e){
            e.printStackTrace();
            return new ResultModel().error("服务器异常");
        }
    }
    @RequestMapping("delUser")
    public ResultModel delUser(Integer id){
        try {
           ssmpUserService.removeById(id);
            return new ResultModel().success("200");
        }catch (Exception e){
            e.printStackTrace();
            return new ResultModel().error("服务器异常");
        }
    }
    @RequestMapping("update")
    public ResultModel update(SsmpUser ssmpUser){
        try {
            ssmpUserService.updateById(ssmpUser);
            return new ResultModel().success(true);
        }catch (Exception e){
            e.printStackTrace();
            return new ResultModel().error("服务器异常");
        }
    }
    @RequestMapping("add")
    public ResultModel add(SsmpUser ssmpUser){
        try {
            ssmpUserService.save(ssmpUser);
            return new ResultModel().success();
        }catch (Exception e){
            e.printStackTrace();
            return new ResultModel().error("服务器异常");
        }
    }
}
