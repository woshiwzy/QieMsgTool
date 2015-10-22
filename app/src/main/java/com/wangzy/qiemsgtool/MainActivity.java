package com.wangzy.qiemsgtool;

import android.os.Bundle;
import android.widget.TextView;

import com.common.BaseActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @InjectView(R.id.textViewNotify)
    TextView textViewNotify;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

    }


    @OnClick(R.id.buttonGetChat)
    public void onButtonGetClick() {

//        /data/data/com.tencent.mobileqq/databases


    }
}
