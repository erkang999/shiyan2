package com.kang.shiyan02.service.iml;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kang.shiyan02.dao.UserDao;
import com.kang.shiyan02.domain.User;
import com.kang.shiyan02.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
//@Transactional
public class UserServiceIml implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    @Transactional
    public boolean login(User user) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("username", user.getUsername());
        qw.eq("password", user.getPassword());
        User user1 = userDao.selectOne(qw);
        return user1!= null;

    }

    @Override
    @Transactional
    public boolean register(User user) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq( "username", user.getUsername());
        User user1 = userDao.selectOne(qw);
       if(user1 == null)
       {
           userDao.insert(user);
           return true;
       }else
       {
           return false;
       }
    }
}
