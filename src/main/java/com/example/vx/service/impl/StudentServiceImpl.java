package com.example.vx.service.impl;

import com.example.vx.entity.Student;
import com.example.vx.entity.Teacher;
import com.example.vx.mapper.StudentMapper;
import com.example.vx.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements IStudentService  {

    @Autowired
    private StudentMapper mapper;

    @Override
    public Boolean login(String username,String password){
        Student student=new Student();
        student.setPhone(username);
        student.setPassword(password);
        int count=mapper.login(student);
        if(count!=0){
            return true;
        }return false;
    }

    @Override
    public String query(String coachid) {
        Student student=new Student();
        student.setPhone(coachid);
        int count=mapper.query(student);
        if(count!=0){
            return "1";
        }return "0";
    }

    @Override
    public void adduser(String coachid,String coachpassword){
        Student student=new Student();
        student.setPhone(coachid);
        student.setPassword(coachpassword);

        Integer rows = mapper.addnew(student);
        System.err.println("数据库添加行数："+rows);
    }

    @Override
    public void wxupdate(String coachid,String coachpassword){
        Student student=new Student();
        student.setPhone(coachid);
        student.setPassword(coachpassword);
        mapper.wxupdate(student);
        System.out.println("成功修改账号为："+coachid+" 的密码");
    }

    @Override
    public List<String> editback(String phone) {
        Student student=new Student();
        student.setPhone(phone);
        Map<String,String> map=mapper.editback(student);
        System.out.println(map);
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
    public Boolean edit(String Sid,String Semail,String Sname,String Smajor,String phonenum) {
        Student student=new Student();
        student.setId(Sid);
        student.setMail(Semail);
        student.setName(Sname);
        student.setMajor(Smajor);
        student.setPhone(phonenum);
        int count=mapper.query(student);
        if(count==0){
            return false;
        }else{
            mapper.edit(student);
            return true;
        }
    }

    @Override
    public Map<String, List<String>> search(String major) {
        Teacher teacher=new Teacher();
        teacher.setClasscode(major);
        teacher.setClasscode2(major);
        List<String> a=mapper.search(teacher);
        List<String> b=mapper.search1(teacher);
        Map<String,List<String>> map=new HashMap<>();
        for(int i=0;i<a.size();i++){
            map.put(a.get(i),spl(b.get(i)));
        }
        return map;
    }

    @Override
    public List<String> time(String name) {
        List<String> a=new ArrayList<>();
        String str= mapper.time(name);
        String stringArray[] = str.split(" ");
        String str1=stringArray[0]+" ";
        String str2=stringArray[1];
        String s[]=str2.split("-");
        String str3=s[0];
        String str4=s[1];
        int index=str3.indexOf(":");
        String str5=str3.substring(0,index+1);
        String t1="30";
        String t2="30-";
        str3=str1+str3+"-"+str5+t1;
        str4=str1+str5+t2+str4;
        a.add(str3);
        a.add(str4);
        return a;
    }

    @Override
    public List<String> spl(String str){
        List<String> a=new ArrayList<>();
        String stringArray[] = str.split(" ");
        String str1=stringArray[0]+" ";
        String str2=stringArray[1];
        String s[]=str2.split("-");
        String str3=s[0];
        String str4=s[1];
        int index=str3.indexOf(":");
        String str5=str3.substring(0,index+1);
        String t1="30";
        String t2="30-";
        str3=str1+str3+"-"+str5+t1;
        str4=str1+str5+t2+str4;
        a.add(str3);
        a.add(str4);
        return a;
    }

    @Override
    public Boolean submit(String phonenum,String chooseT,String classN,String chooseTeacher){
        Student student=new Student();
        student.setPhone(phonenum);
        student.setTime_class(chooseT+"+"+classN+"+"+chooseTeacher);
        student.setTeacher(chooseTeacher);
        int q= mapper.query(student);
        if(q==0){
            return false;
        }else{
        mapper.submit(student);
        return true;
    }
    }

    @Override
    public List<List<String>> sshow(String phonenum) {
        Student student=new Student();
        student.setPhone(phonenum);
        List<String> list=mapper.sshow(student);
        List<List<String>> listarry=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            List<String> array=new ArrayList<>();
            String[] a=list.get(i).split("\\+");
            array.add(a[0]);array.add(a[1]);array.add(a[2]);
            listarry.add(array);
        }return listarry;
    }

}
