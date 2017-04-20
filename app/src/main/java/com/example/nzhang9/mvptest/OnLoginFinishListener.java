package com.example.nzhang9.mvptest;

/**
 * Created by nzhang9 on 2017/3/26.
 */

public interface OnLoginFinishListener {
    void onUserNameError();
    void onPasswordError();
    void onSuccess();
}
