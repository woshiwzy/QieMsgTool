package com.wangzy.qiemsgtool;

import android.os.Bundle;
import android.widget.TextView;

import com.common.BaseActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends BaseActivity {


    @InjectView(R.id.textViewNotify)
    TextView textViewNotify;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        initView();

    }

    @Override
    public void initView() {


    }
}
