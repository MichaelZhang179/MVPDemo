package com.example.nzhang9.mvptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LoginView, View.OnClickListener{
    EditText ed_name;
    EditText ed_password;
    ProgressBar progressBar;
    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_name = (EditText) findViewById(R.id.ed_name);
        ed_password = (EditText) findViewById(R.id.ed_password);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        findViewById(R.id.btn_ok).setOnClickListener(this);

        presenter = new LoginPresenterImpl(this);  // 一定要把 view 传进来
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_ok:
                presenter.validateNameAndPsw(ed_name.getText().toString(), ed_password.getText().toString());
                break;
            default:
                break;
        }
    }

    // begin loginView

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setUserNameError() {
        Toast.makeText(this,"name err", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPasswordError() {
        Toast.makeText(this,"password err", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSucc() {
        Toast.makeText(this,"login success !!!", Toast.LENGTH_SHORT).show();
    }

    // end loginView

}
