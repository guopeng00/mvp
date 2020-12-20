package com.example.mvpchouqu.presenter;

import com.example.mvpchouqu.bean.BannerBean;
import com.example.mvpchouqu.bean.ListBean;
import com.example.mvpchouqu.bean.StudentBean;
import com.example.mvpchouqu.contract.MainContract;
import com.example.mvpchouqu.model.MainModel;
import com.example.mvplibrary.base.BaseModel;
import com.example.mvplibrary.base.BasePresenter;
import com.example.mvplibrary.utils.net.INteCallBack;
import com.example.mvplibrary.utils.net.URlConstant;

import retrofit2.http.Url;

public class MainPresenter extends BasePresenter<MainContract.IView,MainContract.IModel> implements MainContract.IPresenter {

    @Override
    protected MainContract.IModel getModel() {
        return new MainModel();
    }

    @Override
    public void start() {
        iModel.getModel(URlConstant.BANNER, new INteCallBack<BannerBean>() {
            @Override
            public void onSuccess(BannerBean bannerBean) {
                iView.onShow(bannerBean);
            }

            @Override
            public void onFail(String err) {
                iView.onHide(err);
            }
        });
    }

    @Override
    public void start1() {
        iModel.getModel(URlConstant.NEWDATA, new INteCallBack<ListBean>() {
            @Override
            public void onSuccess(ListBean listBean) {
                iView.onShow(listBean);
            }

            @Override
            public void onFail(String err) {
                iView.onHide(err);
            }
        });
    }

    @Override
    public void start2() {
        iModel.getModel(URlConstant.NEWLIST, new INteCallBack<StudentBean>() {
            @Override
            public void onSuccess(StudentBean studentBean) {
                iView.onShow(studentBean);
            }

            @Override
            public void onFail(String err) {
                iView.onHide(err);
            }
        });
    }
}
