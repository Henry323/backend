package com.example.vx.service;

import com.example.vx.entity.Teacher;

import java.util.List;
import java.util.Map;

public interface ITeacherService {

     Boolean login(String username,String password);

    String query(String coachid);

    //将账号密码存入数据库
    void adduser(String coachid,String coachpassword);

    //修改微信小程序指定老师账号的密码
    void wxupdate(String coachid,String coachpassword);

    Boolean publish(String classcode,String time,String phone);

    Boolean edit(String Temail,String Tname,String Tmajor1,String Tmajor2,String phonenum);

    List<String> editback(String phone);

    List<String> login_get(String phone);

    String getname(String phone);

    List<List<String>> tshow(String name);
}
