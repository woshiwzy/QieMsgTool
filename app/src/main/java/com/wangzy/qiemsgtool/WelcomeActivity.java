package com.wangzy.qiemsgtool;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

import com.common.BaseActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnCheckedChanged;

public class WelcomeActivity extends BaseActivity {


    @InjectView(R.id.buttonGo)
    Button buttonGo;


    @InjectView(R.id.checkTextAgreeContent)
    CheckBox checkTextAgreeContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        ButterKnife.inject(this);

    }


    @OnCheckedChanged(R.id.checkTextAgreeContent)
    public void onCheckAgreement() {


        buttonGo.setEnabled(checkTextAgreeContent.isChecked());


    }


}
