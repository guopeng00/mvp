package com.example.mvpchouqu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mvpchouqu.view.LoginActivity;
import com.youth.banner.Banner;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private Banner banner;
    private TextView tvName;
    private ImageView ivImg;
    private Disposable subscribe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        tvName = (TextView) findViewById(R.id.tv_name);
        tvName.setText("倒计时："+"5");
        ivImg = (ImageView) findViewById(R.id.iv_img);
        subscribe = Observable.interval(0, 1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Long time = 5 - aLong;
                        tvName.setText("倒计时："+time);
                        if (time == 0) {
                            startActivity(new Intent(MainActivity.this, LoginActivity.class));
                            finish();
                            //关闭倒计时
                            subscribe.dispose();
                        }
                    }
                });
    }
}