package com.example.mvplibrary.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment<T extends BasePresenter> extends Fragment implements BaseView {
    protected T presenter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutID(), null);
        if(presenter==null){
            presenter=getPresnter();
            presenter.attachView(this);
        }
        initView(view);
        initData();
        return view;
    }

    protected abstract T getPresnter();

    protected abstract void initData();

    protected abstract void initView(View view);

    protected abstract int getLayoutID();
}
