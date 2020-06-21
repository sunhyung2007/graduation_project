package com.example.myapplication;

import android.service.autofill.UserData;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
public class UserDatabase {
    @PrimaryKey(autoGenerate = true)
    @NotNull
    private  int i = 0;
    private String user_id;
    private String sub;
    private String basic;
    private String hard;
    private String nes1;
    private String nes2;
    private String select1;
    private String select2;
    private String select3;

   /*UserDatabase() {
        this.user_id = "";
        this.sub = "";
        this.basic = "";
        this.hard = null;
        this.nes1 = null;
        this.nes2 = null;
        this.select1 = null;
        this.select2 = null;
        this.select3 = null;
    }*/
    UserDatabase(String user_id, String sub, String basic, String hard, String nes1, String nes2, String select1, String select2, String select3){
        this.user_id = user_id;
        this.sub = sub;
        this.basic = basic;
        this.hard = hard;
        this.nes1 = nes1;
        this.nes2 = nes2;
        this.select1 = select1;
        this.select2 = select2;
        this.select3 = select3;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getBasic() {
        return basic;
    }

    public void setBasic(String basic) {
        this.basic = basic;
    }

    public String getHard() {
        return hard;
    }

    public void setHard(String hard) {
        this.hard = hard;
    }

    public String getNes1() {
        return nes1;
    }

    public void setNes1(String nes1) {
        this.nes1 = nes1;
    }

    public String getNes2() {
        return nes2;
    }

    public void setNes2(String nes2) {
        this.nes2 = nes2;
    }

    public String getSelect1() {
        return select1;
    }

    public void setSelect1(String select1) {
        this.select1 = select1;
    }

    public String getSelect2() {
        return select2;
    }

    public void setSelect2(String select2) {
        this.select2 = select2;
    }

    public String getSelect3() {
        return select3;
    }

    public void setSelect3(String select3) {
        this.select3 = select3;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}