package com.dj.ssm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dj.ssm.mapper.SsmpUserMapper;
import com.dj.ssm.pojo.SsmpUser;
import com.dj.ssm.service.SsmpUserService;
import org.springframework.stereotype.Service;

@Service
public class SsmpUserServiceImpl extends ServiceImpl<SsmpUserMapper, SsmpUser> implements SsmpUserService {
}
