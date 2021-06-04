package com.example.vx.mapper;

import com.example.vx.entity.Student;
import com.example.vx.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    int login(Student student);

    int query(Student student);

    //将账号密码存入数据库
    Integer addnew(Student student);

    void wxupdate(Student student);

    Map<String,String> editback(Student student);

    void edit(Student student);

    List<String> search(Teacher teacher);

    List<String> search1(Teacher teacher);

    String time(String name);

    void submit(Student student);

    List<String> sshow(Student student);
}
