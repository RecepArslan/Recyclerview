package com.example.proje2_rcyclerview;

import java.security.PrivateKey;

public class person_model {
    private String name;
    private int gender;
    private  int work;

    public person_model(String name, int gender, int work) {
        this.name = name;
        this.gender = gender;
        this.work = work;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getWork() {
        return work;
    }

    public void setWork(int work) {
        this.work = work;
    }
}
