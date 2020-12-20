package com.example.lianxiapplication;

import com.example.mvplibrary.base.BaseActivity;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.IView {


    @Override
    protected void initData() {
        presenter.onStart1();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public MainPresenter getPresenter() {
        return new MainPresenter();
    }

    @Override
    public void onShow(Object object) {

    }

    @Override
    public void onHide(String url) {

    }
}