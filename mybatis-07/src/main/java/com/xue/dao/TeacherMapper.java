package com.xue.dao;

import com.xue.pojo.Teacher;

import java.util.List;

public interface TeacherMapper {
    //获取学生
    List<Teacher> teacher1();
    //获取指定老师下的所有学生及老师信息
    List<Teacher> getTeacher(int i);

    List<Teacher> getTeacher2(int i);
}
