package com.example.vx.controller;

import com.example.vx.entity.Teacher;
import com.example.vx.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("teacher")
public class TeacherController {

    @Autowired
    private ITeacherService service;

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

    //将老师发送验证码到老师电话中,默认验证码为12345
    @RequestMapping("val")
    @ResponseBody
    public String val(String coachid){
        System.out.println("用户手机号："+coachid);
        return "12345";
    }

    //将老师注册的账号（电话号码）密码存入数据库
    @RequestMapping("insert")
    @ResponseBody
    public void insert(String coachid,String coachpassword){
        System.out.println("注册账号："+coachid);
        System.out.println("注册密码："+coachpassword);
        service.adduser(coachid,coachpassword);
    }

    //修改老师的密码
    @RequestMapping("wxupdate")
    @ResponseBody
    public void wxupdate(String coachid,String coachpassword){
        service.wxupdate(coachid,coachpassword);
    }

    //将老师发布的时间和课程代码存入数据库中
    @RequestMapping("publish")
    @ResponseBody
    public boolean publish(String Tclasscode,String Tofficehour,String Tphonenum){
        return service.publish(Tclasscode,Tofficehour,Tphonenum);
    }

    //将老师的个人信息存入数据库
    @RequestMapping("edit")
    @ResponseBody
    public boolean edit(String Temail,String Tname,String Tmajor1,String Tmajor2,String phonenum){
        return service.edit(Temail,Tname,Tmajor1,Tmajor2,phonenum);
    }

    //返回数据库中指定老师的信息
    @RequestMapping("editback")
    @ResponseBody
    public List<String> editback(String phonenum){
        List<String> a=service.editback(phonenum);
        System.out.println(a);
        return service.editback(phonenum);
    }

    //老师登录成功后通过老师手机号码返回其相应的两门课程
    @RequestMapping("login_get")
    @ResponseBody
    public List<String> login_get(String username){
        List<String> a=service.login_get(username);
        System.out.println(a);
        return service.login_get(username);
    }

    @RequestMapping("getname")
    @ResponseBody
    public String getname(String phonenum){
        System.out.println(service.getname(phonenum));
        return service.getname(phonenum);
    }

    @RequestMapping("tshow")
    @ResponseBody
    public List<List<String>> tshow(String teachername){
        return service.tshow(teachername);
    }
}
