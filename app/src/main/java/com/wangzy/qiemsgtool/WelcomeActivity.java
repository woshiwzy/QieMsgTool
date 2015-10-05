package com.wangzy.qiemsgtool;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

import com.common.BaseActivity;
import com.common.util.DialogUtils;
import com.common.util.Root;
import com.common.util.Tool;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

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


    @OnClick(R.id.buttonGo)
    public void onGoClick() {

        Root root = new Root();

        if (root.isDeviceRooted()) {
            Tool.startActivity(this, MainActivity.class);
        } else {



        }


    }

}
