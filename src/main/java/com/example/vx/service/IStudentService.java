package com.example.vx.service;

import com.example.vx.entity.Teacher;

import java.util.List;
import java.util.Map;

public interface IStudentService {
    Boolean login(String username,String password);

    String query(String coachid);

    //将账号密码存入数据库
    void adduser(String coachid,String coachpassword);

    //修改微信小程序指定学生账号的密码
    void wxupdate(String coachid,String coachpassword);

    List<String> editback(String phone);

    Boolean edit(String Sid,String Semail,String Sname,String Smajor,String phonenum);

    Map<String,List<String>> search(String major);

    List<String> time(String name);

    List<String> spl(String str);

    Boolean submit(String phonenum,String chooseT,String classN,String chooseTeacher);

    List<List<String>> sshow(String phonenum);

}
