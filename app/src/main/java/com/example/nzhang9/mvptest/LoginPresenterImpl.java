package com.example.nzhang9.mvptest;

/**
 * Created by nzhang9 on 2017/3/26.
 */

public class LoginPresenterImpl implements LoginPresenter, OnLoginFinishListener{

    LoginView loginView;
    LoginModel loginModel;

    public LoginPresenterImpl(LoginView loginView) {  // 一定是 view 传进来

        this.loginView = loginView;

        loginModel = new LoginModelImpl();
    }

    // being loginPresent

    @Override
    public void validateNameAndPsw(String username, String password) {
        if(loginView != null) {
            loginView.showProgress();
        }

        // OnLoginFinishListener的作用就是 1 给 model 层回调，2 更改 view 状态

        loginModel.login(username, password, this);  // this 把自身传给model，这里是1
    }

    // end loginPresent


    // begin OnLoginFinishListener

    @Override
    public void onUserNameError() {
        if(loginView != null) {  // 这里是2
            loginView.setUserNameError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        if(loginView != null) {   // 这里是2
            loginView.setPasswordError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        if(loginView != null) {   // 这里是2
            loginView.loginSucc();
            loginView.hideProgress();
        }
    }

    // end OnLoginFinishListener
}
