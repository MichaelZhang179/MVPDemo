package com.example.nzhang9.mvptest;

/**
 * Created by nzhang9 on 2017/3/26.
 */

public interface LoginModel {

    public void login(String name, String password, OnLoginFinishListener listener);
}
