package com.example.lianxiapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mvplibrary.base.BaseActivity;
import com.example.mvplibrary.base.BasePresenter;

public class MainActivity extends BaseActivity {


    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public BasePresenter getPresenter() {
        return null;
    }
}