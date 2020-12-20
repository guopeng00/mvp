package com.example.mvpchouqu.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mvpchouqu.R;

public class LoginActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etPwd;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        SharedPreferences key = getSharedPreferences("key", MODE_PRIVATE);
        boolean k = key.getBoolean("k", false);
        if(k==true){
            startActivity(new Intent(LoginActivity.this,HomeActivity.class));
            finish();
        }
    }

    private void initView() {
        etName = (EditText) findViewById(R.id.et_name);
        etPwd = (EditText) findViewById(R.id.et_pwd);
        btnLogin = (Button) findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String pwd = etPwd.getText().toString();
                if(name.equals("123")&&pwd.equals("456")){
                    startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                    SharedPreferences key = getSharedPreferences("key", MODE_PRIVATE);
                    SharedPreferences.Editor edit = key.edit();
                    edit.putBoolean("k",true);
                    edit.commit();
                    finish();
                }
            }
        });
    }
}