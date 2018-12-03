package com.vainius.augustinas.lms_android.common;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RootViewMVCImpl mViewMVC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewMVC = new RootViewMVCImpl(this,null);
        setContentView(mViewMVC.getRootView());
    }
}
