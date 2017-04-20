package com.example.nzhang9.mvptest;

import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by nzhang9 on 2017/3/26.
 */

public class LoginModelImpl implements LoginModel{

    @Override
    public void login(final String name, final String password, final OnLoginFinishListener listener) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean bErr = false;
                if(TextUtils.isEmpty(name)) {
                    bErr = true;
                    listener.onUserNameError();

                    return ;
                }

                if(TextUtils.isEmpty(password)) {
                    bErr = true;
                    listener.onPasswordError();

                    return ;
                }

                if(!bErr) {
                    listener.onSuccess();
                }
            }
        }, 2000);
    }
}
