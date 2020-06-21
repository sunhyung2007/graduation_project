/*2020.06.20
작성자:안한길
Userinfo 클래스를 선언하고 db로 사용
 */
package com.example.myapplication;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Userinfo {
    @PrimaryKey(autoGenerate = true)
    private int usernum;
    private String user_id;
    private  String user_pwd;
    private String hakbun;
    private int grade;

    public Userinfo(String user_id, String user_pwd, String hakbun) {
        this.user_id=user_id;
        this.user_pwd=user_pwd;
        this.hakbun=hakbun;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public String getHakbun() {
        return hakbun;
    }

    public void setHakbun(String hakbun) {
        this.hakbun = hakbun;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Userinfo{" +
                "user_id='" + user_id + '\'' +
                ", user_pwd='" + user_pwd + '\'' +
                ", hakbun='" + hakbun + '\'' +

                '}';
    }

    public int getUsernum() {
        return usernum;
    }

    public void setUsernum(int usernum) {
        this.usernum = usernum;
    }
}
