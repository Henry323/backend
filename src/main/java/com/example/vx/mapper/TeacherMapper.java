package com.example.vx.mapper;

import com.example.vx.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TeacherMapper {

    int login(Teacher teacher);

    int query(Teacher teacher);

    //将账号密码存入数据库
    Integer addnew(Teacher teacher);

    void wxupdate(Teacher teacher);

    void publish(Teacher teacher);

    void edit(Teacher teacher);

    Map<String,String> editback(Teacher teacher);

    Map<String,String> login_get(Teacher teacher);

    String getname(Teacher teacher);

    List<String> tshow(Teacher teacher);

    List<String> SelectStudentPhone(Teacher teacher);
}
