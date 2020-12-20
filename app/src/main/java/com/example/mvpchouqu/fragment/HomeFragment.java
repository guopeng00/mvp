package com.example.mvpchouqu.fragment;

import android.view.View;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvpchouqu.R;
import com.example.mvpchouqu.bean.ListBean;
import com.example.mvpchouqu.contract.MainContract;
import com.example.mvpchouqu.presenter.MainPresenter;
import com.example.mvplibrary.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment<MainPresenter> implements MainContract.IView {

    private RecyclerView rlvHome;
    private ArrayList<ListBean.NewsBean> mList;
    private HomeAdapter mAdapter;


    @Override
    protected MainPresenter getPresnter() {
        return new MainPresenter();
    }

    @Override
    protected void initData() {
        presenter.start1();
    }

    @Override
    protected void initView(View view) {
        rlvHome = (RecyclerView) view.findViewById(R.id.rlv_home);
        rlvHome.setLayoutManager(new LinearLayoutManager(getActivity()));
        rlvHome.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        mList = new ArrayList<>();
        mAdapter = new HomeAdapter(getActivity(), mList);
        rlvHome.setAdapter(mAdapter);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_home;
    }

    @Override
    public void onShow(Object object) {
        if(object instanceof ListBean){
            ListBean listBean= (ListBean) object;
            List<ListBean.NewsBean> news = listBean.getNews();
            mList.addAll(news);
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onHide(String str) {

    }
}
