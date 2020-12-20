package com.example.mvpchouqu.model;

import com.example.mvpchouqu.contract.MainContract;
import com.example.mvplibrary.utils.net.INteCallBack;
import com.example.mvplibrary.utils.net.RetrofitUtils;

public class MainModel implements MainContract.IModel {
    @Override
    public <T> void getModel(String url, INteCallBack<T> callBack) {
        RetrofitUtils.getRetrofitUtils().get(url,callBack);
    }
}
