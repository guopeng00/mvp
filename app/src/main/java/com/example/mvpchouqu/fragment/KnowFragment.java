package com.example.mvpchouqu.fragment;

import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvpchouqu.R;
import com.example.mvpchouqu.adapter.KnowAdapter;
import com.example.mvpchouqu.bean.StudentBean;
import com.example.mvpchouqu.contract.MainContract;
import com.example.mvpchouqu.presenter.MainPresenter;
import com.example.mvplibrary.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class KnowFragment extends BaseFragment<MainPresenter> implements MainContract.IView {

    private RecyclerView rlvKnow;
    private ArrayList<StudentBean.StudenlistBean> mStu;
    private KnowAdapter mAdapter;

    @Override
    protected MainPresenter getPresnter() {
        return new MainPresenter();
    }

    @Override
    protected void initData() {
        presenter.start2();
    }

    @Override
    protected void initView(View view) {
        rlvKnow = (RecyclerView) view.findViewById(R.id.rlv_know);
        rlvKnow.setLayoutManager(new LinearLayoutManager(getActivity()));
        rlvKnow.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        mStu = new ArrayList<>();
        mAdapter = new KnowAdapter(getActivity(), mStu);
        rlvKnow.setAdapter(mAdapter);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_know;
    }

    @Override
    public void onShow(Object object) {
        if(object instanceof StudentBean){
            StudentBean studentBean= (StudentBean) object;
            List<StudentBean.StudenlistBean> studenlist = studentBean.getStudenlist();
            mStu.addAll(studenlist);
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onHide(String str) {
        Log.e("TAG", "onHide: "+str );
    }
}
