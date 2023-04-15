package com.kang.shiyan02.service.iml;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kang.shiyan02.dao.s_studentDao;
import com.kang.shiyan02.domain.s_student;
import com.kang.shiyan02.service.s_studentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class s_studentServiceIml implements s_studentService {

    @Resource
    private s_studentDao s_studentDao;

    @Override
    public List<s_student> getAll() {
        return s_studentDao.selectList(null);
    }

    @Override
    public String add(s_student student) {
//          s_studentDao.insert(student);
        QueryWrapper<s_student> qw = new QueryWrapper<>();
        qw.eq("name",student.getName());
        s_student s_student = s_studentDao.selectOne(qw); //要求：课程名不能与已有的课程重复
        if(s_student==null)
        {
            s_studentDao.insert(student);
            return "success";
        }
        return "error";
    }

    @Override
    public String update(s_student student) {
       QueryWrapper<s_student> qw = new QueryWrapper<>();
       qw.ne("id",student.getId());
       qw.eq("name",student.getName());
        s_student s_student = s_studentDao.selectOne(qw);
//        System.out.println(s_student);：新修改课程名不能与已有的
//课程名重复。
        if(s_student==null)
        {
//            s_studentDao.upda
            s_studentDao.updateById(student);
            return "success";

        }else
        {
            return "error";
        }

    }

    @Override
    public String deleteById(Integer id) {
        int i = s_studentDao.deleteById(id);
        System.out.println("delete " + id  );//delete 6
        if(i>0)
        {
            return "success";
        }else
        {
            return "error";
        }
    }
}

