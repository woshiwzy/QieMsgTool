package com.wangzy.qiemsgtool;

import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

import com.common.BaseActivity;
import com.common.util.DialogCallBackListener;
import com.common.util.DialogUtils;
import com.common.util.Root;
import com.common.util.Tool;

import java.util.Locale;

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

            searchRoot(Build.MODEL);

//            Tool.startActivity(this, MainActivity.class);
        } else {

            String title = getResources().getString(R.string.main_not_root);
            String msg = getResources().getString(R.string.main_search_root);

            String yes = getResources().getString(R.string.confirm);
            String no = getResources().getString(R.string.cancell);

            DialogUtils.showConfirmDialog(this, title, msg, yes, no, new DialogCallBackListener() {

                @Override
                public void onDone(boolean yesOrNo) {


//                    android.os.Build.MODEL



                    if (yesOrNo) {

                        searchRoot(Build.MODEL);
                    } else {


                    }

                }
            });


        }


    }


    private void searchRoot(String model) {


        if (isZh()) {

            String url = "https://www.baidu.com/s?wd=root%20" + model;

            Tool.startUrl(this, url);

        } else {

            String url = "https://www.google.com/search?q=how+to+root+nexus&oq=how+to+root+" + model;

            Tool.startUrl(this, url);

        }


    }


    private boolean isZh() {
        Locale locale = getResources().getConfiguration().locale;
        String language = locale.getLanguage();
        if (language.endsWith("zh"))
            return true;
        else
            return false;
    }
}
