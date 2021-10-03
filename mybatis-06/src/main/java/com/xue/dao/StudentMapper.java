package com.xue.dao;


import com.xue.pojo.Student;

import java.util.List;

public interface StudentMapper {

    //查询所以学生信息以及老师的信息
    public List<Student> getStudent();
    public List<Student> getStudent2();
}
