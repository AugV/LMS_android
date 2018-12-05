package com.vainius.augustinas.lms_android.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.vainius.augustinas.lms_android.common.BaseFragment;

public class LoginPageFragment extends BaseFragment implements LoginPageViewMVC.LoginPageViewMVCListener{


    LoginPageViewMVC mViewMVC;

    String[] temp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        mViewMVC = new LoginPageViewMVCImpl(inflater, container);
        mViewMVC.setListener(this);
        return mViewMVC.getRootView();
    }



    @Override
    public void onLoginButtonClicked(String loginId, String loginPsw) {
            Bundle args = new Bundle(2);
            args.putString("student_id", loginId);
            args.putString("student_psw", loginPsw);
    }

}
