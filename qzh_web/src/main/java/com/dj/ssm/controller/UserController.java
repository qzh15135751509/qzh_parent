package com.dj.ssm.controller;

import com.dj.ssm.pojo.HttpClientUtil;
import com.dj.ssm.pojo.ResultModel;
import com.dj.ssm.pojo.SsmpUser;
import com.dj.ssm.service.SsmpUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private SsmpUserService ssmpUserService;


    /**
     * 根据用户ID获取用户信息
     * @URL GET /users/id
     */
    @GetMapping("/{id}")
    private ResultModel get(@PathVariable Integer id){
        try {
            SsmpUser user = ssmpUserService.getById(id);
            return new ResultModel<Object>().success(user);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultModel().error(e.getMessage());
        }
    }

    /**
     * 保存用户
     * @URL POST /users
     * @return
     */
    @PostMapping
    public ResultModel save(SsmpUser user) {
        try {
            ssmpUserService.save(user);
            return new ResultModel().success(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultModel().error(e.getMessage());
        }
    }

    /**
     * 修改用户信息
     * @URL PUT /users
     * @return
     */
    @PutMapping
    public ResultModel update(SsmpUser user) {
 //   public ResultModel update(@RequestBody User user) {
        try {
            ssmpUserService.updateById(user);
            return new ResultModel().success(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultModel().error(e.getMessage());
        }
    }

    /**
     * 删除用户
     * @URL DELETE /users/id
     * @return
     */
    @DeleteMapping
//    public ResultModel delete(@PathVariable Integer id) {
      public ResultModel delete(Integer id) {
        try {
            ssmpUserService.removeById(id);
            return new ResultModel().success(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultModel().error(e.getMessage());
        }
    }

    /**
     * 简单列表查询
     * @URL GET /users
     * @return
     */
    @GetMapping
    public ResultModel list1() {
        try {
            List<SsmpUser> list = ssmpUserService.list();
            return new ResultModel().success(list);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultModel().error(e.getMessage());
        }
    }

    /**
     * 文件上传
     * @param file
     * @return
     */
    @RequestMapping("/upload")
    public ResultModel<Object> upload(MultipartFile file){
        try {
            String filename = file.getOriginalFilename();
            System.out.println(filename);
            if (!file.isEmpty()) {
                String dirPath = "F:/upload/";
                File f = new File(dirPath);
                if (!f.exists()) {
                    f.mkdirs();
                }
                file.transferTo(new File(dirPath + filename));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *正向代理
     * @return
     */
    @RequestMapping("/show")
    public ResultModel<Object> show(String url) {
        try {
            String w = HttpClientUtil.sendHttpRequest(url, HttpClientUtil.HttpRequestMethod.GET, null);
            System.out.println(w);
            return new ResultModel<>().success(w);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultModel<>().error("服务器异常,请稍后再试");
        }

    }


}
