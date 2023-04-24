package com.kang.shiyan02.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kang.shiyan02.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper()
public interface UserDao extends BaseMapper<User> {
}
