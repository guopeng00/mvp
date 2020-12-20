package com.example.lianxiapplication;

import com.example.mvplibrary.base.BasePresenter;

public class MainPresenter extends BasePresenter<MainContract.IView,MainContract.IModel> implements MainContract.IPresenter {

    @Override
    public void onStart1() {

    }

    @Override
    protected MainContract.IModel getModel() {
        return new MainModel();
    }
}
