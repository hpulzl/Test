package qb.edu.com.testsystem.entity;

import java.io.Serializable;

/**
 * Created by admin on 2016/4/4.
 * 用户类
 * 昵称，密码，班级
 */
public class User implements Serializable{
    private String userName;   //学生id
    private String password;
    private String classGrade;
    private String name;  //学生姓名

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClassGrade() {
        return classGrade;
    }

    public void setClassGrade(String classGrade) {
        this.classGrade = classGrade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", classGrade='" + classGrade + '\'' +",name="+name+
                '}';
    }
}
