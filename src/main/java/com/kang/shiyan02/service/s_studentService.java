package com.kang.shiyan02.service;

import com.kang.shiyan02.domain.s_student;

import java.util.List;

public interface s_studentService {

    List<s_student> getAll();
   String add(s_student student);
    String update(s_student student);
    String deleteById(Integer id);
}
