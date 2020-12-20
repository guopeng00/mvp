package com.example.mvpchouqu;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.youth.banner.Banner;

public class MainActivity extends AppCompatActivity {

    private Banner banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        banner = (Banner) findViewById(R.id.banner);
    }
}