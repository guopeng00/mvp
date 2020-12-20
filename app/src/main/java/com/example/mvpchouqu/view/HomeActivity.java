package com.example.mvpchouqu.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.mvpchouqu.R;
import com.example.mvpchouqu.adapter.VPAdapter;
import com.example.mvpchouqu.bean.BannerBean;
import com.example.mvpchouqu.contract.MainContract;
import com.example.mvpchouqu.fragment.HomeFragment;
import com.example.mvpchouqu.fragment.KnowFragment;
import com.example.mvpchouqu.presenter.MainPresenter;
import com.example.mvplibrary.base.BaseActivity;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HomeActivity extends BaseActivity<MainPresenter> implements MainContract.IView {

    private Banner myBanner;
    private TabLayout tab;
    private ViewPager vp;
    private ArrayList<Fragment> frag;
    private String[] names={"首页","网页"};
    private VPAdapter mAdapter;

    @Override
    protected void initData() {
        presenter.start();

    }

    protected void initView() {
        myBanner = (Banner) findViewById(R.id.my_banner);
        vp = (ViewPager) findViewById(R.id.vp);
        tab = (TabLayout) findViewById(R.id.tab);
        frag = new ArrayList<>();
        frag.add(new HomeFragment());
        frag.add(new KnowFragment());
        mAdapter = new VPAdapter(getSupportFragmentManager(), frag, names);
        vp.setAdapter(mAdapter);
        tab.setupWithViewPager(vp);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_home;
    }

    @Override
    public MainPresenter getPresenter() {
        return new MainPresenter();
    }

    @Override
    public void onShow(Object object) {
        if(object instanceof BannerBean){
            BannerBean bannerBean= (BannerBean) object;
            List<BannerBean.BannerlistBean> bannerlist = bannerBean.getBannerlist();
            myBanner.setImages(bannerlist).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    BannerBean.BannerlistBean image= (BannerBean.BannerlistBean) path;
                    Glide.with(HomeActivity.this).load(image.getImageurl()).into(imageView);
                }
            }).start();
        }
    }

    @Override
    public void onHide(String str) {
        Log.e("TAG", "onHide: "+str);
    }
}