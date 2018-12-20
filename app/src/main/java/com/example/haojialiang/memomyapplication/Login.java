package com.example.haojialiang.memomyapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;

public class Login extends AppCompatActivity {

    @BindView(R.id.tv_al_account)
    AutoCompleteTextView tvAlAccount;
    @BindView(R.id.tv_al_password)
    EditText tvAlPassword;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.regitster)
    TextView regitster;
    @BindView(R.id.email_login_form)
    LinearLayout emailLoginForm;
    @BindView(R.id.login_form)
    ScrollView loginForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


}
