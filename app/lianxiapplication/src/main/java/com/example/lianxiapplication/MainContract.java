package com.example.lianxiapplication;

import com.example.mvplibrary.base.BaseModel;
import com.example.mvplibrary.base.BaseView;
import com.example.mvplibrary.utils.net.INteCallBack;

public class MainContract {
    public interface IModel extends BaseModel {
        <T> void getModel(String url, INteCallBack<T> callBack);
    }
    public interface IView extends BaseView {
        void onShow(Object object);
        void onHide(String url);
    }
    public interface IPresenter{
        void onStart1();
    }
}
