package com.example.vx.controller;

import com.example.vx.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentServiceImpl service;

    //验证小程序登录账号是否正确
    @RequestMapping("login")
    @ResponseBody
    public Boolean login(String username,String password){
        System.out.println(username+" "+password);
        Boolean login = service.login(username,password);
        if(login){
            return true;
        }
        return false;
    }

    //检测账号是否被注册，已被注册返回1 ，未被注册返回0
    @RequestMapping("reg")
    @ResponseBody
    public String reg(String coachid){
        String que=service.query(coachid);
        return que;
    }

    //将学生发送验证码到老师电话中,默认验证码为12345
    @RequestMapping("val")
    @ResponseBody
    public String val(String coachid){
        System.out.println("用户手机号："+coachid);
        return "12345";
    }

    //将学生注册的账号（电话号码）密码存入数据库
    @RequestMapping("insert")
    @ResponseBody
    public void insert(String coachid,String coachpassword){
        System.out.println("注册账号："+coachid);
        System.out.println("注册密码："+coachpassword);
        service.adduser(coachid,coachpassword);
    }

    //修改学生的密码
    @RequestMapping("wxupdate")
    @ResponseBody
    public void wxupdate(String coachid,String coachpassword){
        service.wxupdate(coachid,coachpassword);
    }

    //返回数据库中指定学生的信息
    @RequestMapping("editback")
    @ResponseBody
    public List<String> editback(String phonenum){
        List<String> a=service.editback(phonenum);
        System.out.println(a);
        return service.editback(phonenum);
    }

    //将学生的个人信息存入数据库
    @RequestMapping("edit")
    @ResponseBody
    public boolean edit(String Sid,String Semail,String Sname,String Smajor,String phonenum){
        return service.edit(Sid,Semail,Sname,Smajor,phonenum);
    }

    //根据专业返回对应老师的名字
    @RequestMapping("search")
    @ResponseBody
    public Map<String,List<String>> search(String say){
        return service.search(say);
    }

    //根据老师名字返回对应的老师时间
    @RequestMapping("time")
    @ResponseBody
    public List<String> time(String choosename){
        System.out.println(choosename);
        return service.time(choosename);
    }

    //将学生选择的课程，老师和时间存入对应的数据库中
    @RequestMapping("submit")
    @ResponseBody
    public Boolean submit(String phonenum,String chooseT,String classN,String chooseTeacher){
        return service.submit(phonenum,chooseT,classN,chooseTeacher);
    }

    //提取学生的预订信息
    @RequestMapping("sshow")
    @ResponseBody
    public List<List<String>> sshow(String phonenum){
        return service.sshow(phonenum);
    }

}
