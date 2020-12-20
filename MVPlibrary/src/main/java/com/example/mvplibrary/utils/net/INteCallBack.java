package com.example.mvplibrary.utils.net;

public interface INteCallBack<T> {
    void onSuccess(T t);
    void onFail(String err);
}
