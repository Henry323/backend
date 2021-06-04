package com.example.vx.service.impl;

import com.example.vx.entity.Student;
import com.example.vx.entity.Teacher;
import com.example.vx.mapper.TeacherMapper;
import com.example.vx.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TeacherServiceImpl implements ITeacherService {

    @Autowired
    private TeacherMapper mapper;

    @Override
    public Boolean login(String username,String password){
        Teacher teacher=new Teacher();
        teacher.setPhone(username);
        teacher.setPassword(password);
        int count=mapper.login(teacher);
        if(count!=0){
            return true;
        }return false;
    }

    @Override
    public String query(String coachid) {
        Teacher teacher=new Teacher();
        teacher.setPhone(coachid);
        int count=mapper.query(teacher);
        if(count!=0){
            return "1";
        }return "0";
    }

    @Override
    public void adduser(String coachid,String coachpassword){
        Teacher teacher=new Teacher();
        teacher.setPhone(coachid);
        teacher.setPassword(coachpassword);

        Integer rows = mapper.addnew(teacher);
        System.err.println("数据库添加行数："+rows);
    }

    @Override
    public void wxupdate(String coachid,String coachpassword){
        Teacher teacher=new Teacher();
        teacher.setPhone(coachid);
        teacher.setPassword(coachpassword);
        mapper.wxupdate(teacher);
        System.out.println("成功修改账号为："+coachid+" 的密码");
    }

    @Override
    public Boolean publish(String classcode, String time, String phone) {
        Teacher teacher=new Teacher();
        teacher.setClasscode(classcode);
        teacher.setTime(time);
        teacher.setPhone(phone);
        int count=mapper.query(teacher);
        if(count==0){
            return false;
        }else{
            mapper.publish(teacher);
            return true;
        }
    }

    @Override
    public Boolean edit(String Temail, String Tname, String Tmajor1, String Tmajor2, String phonenum) {
        Teacher teacher=new Teacher();
        teacher.setMail(Temail);
        teacher.setName(Tname);
        teacher.setClasscode(Tmajor1);
        teacher.setClasscode2(Tmajor2);
        teacher.setPhone(phonenum);
        int count=mapper.query(teacher);
        if(count==0){
            return false;
        }else{
            mapper.edit(teacher);
            return true;
        }
    }

    @Override
    public List<String> editback(String phone) {
        Teacher teacher=new Teacher();
        teacher.setPhone(phone);
        Map<String,String> map=mapper.editback(teacher);
        if(map==null){
            List<String> list=new ArrayList<>();
            list.add("undefine");
            list.add("undefine");
            list.add("undefine");
            list.add("undefine");
            return list;
        }else{
            List<String> list=new ArrayList<>();
            for(Map.Entry<String, String> vo : map.entrySet()){
                list.add(vo.getValue());
            }
            return list;
        }
    }

    @Override
    public List<String> login_get(String phone) {
        Teacher teacher=new Teacher();
        teacher.setPhone(phone);
        Map<String,String> map=mapper.login_get(teacher);
        List<String> list=new ArrayList<>();
        for(Map.Entry<String, String> vo : map.entrySet()){
            list.add(vo.getValue());
        }
        return list;
    }

    @Override
    public String getname(String phone) {
        Teacher teacher=new Teacher();
        teacher.setPhone(phone);
        return mapper.getname(teacher);
    }

    @Override
    public List<List<String>> tshow(String name){
        Teacher teacher=new Teacher();
        teacher.setName(name);
        List<String> list=mapper.tshow(teacher);
        List<String> phone=mapper.SelectStudentPhone(teacher);
        List<List<String>> listarry=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            List<String> array=new ArrayList<>();
            String[] a=list.get(i).split("\\+");
            array.add(a[0]);array.add(a[1]);array.add(phone.get(i));
            listarry.add(array);
        }return listarry;
    }

}
