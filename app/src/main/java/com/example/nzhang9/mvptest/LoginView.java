package com.example.nzhang9.mvptest;

/**
 * Created by nzhang9 on 2017/3/26.
 */

public interface LoginView {

    void showProgress();

    void hideProgress();

    void setUserNameError();

    void setPasswordError();

    void loginSucc();
}
