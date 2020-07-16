package com.dj.ssm.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("ssmp_user")
public class SsmpUser {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String userName;

    private String userPwd;

    private Integer userAge;

    private Integer userSex;
}
