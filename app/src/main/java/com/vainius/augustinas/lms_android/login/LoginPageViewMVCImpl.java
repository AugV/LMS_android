package com.vainius.augustinas.lms_android.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.vainius.augustinas.lms_android.R;

public class LoginPageViewMVCImpl implements LoginPageViewMVC {

    private View mRootView;
    private LoginPageViewMVCListener mListener;
    private Button mLoginButton;
    private EditText mLoginId;
    private EditText mLoginPsw;

    public LoginPageViewMVCImpl(LayoutInflater inflater, ViewGroup container) {
        mRootView = inflater.inflate(R.layout.mvc_view_login_page, container, false);

        mLoginId = (EditText) mRootView.findViewById(R.id.student_id);
        mLoginPsw = (EditText) mRootView.findViewById(R.id.student_psw);

        mLoginButton = (Button) mRootView.findViewById(R.id.student_login);
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener!=null){
                    mListener.onLoginButtonClicked(mLoginId.getText().toString(),mLoginPsw.getText().toString());
                }
            }
        });
    }

    @Override
    public void setListener(LoginPageViewMVCListener listener) {
        mListener = listener;
    }

    @Override
    public View getRootView() {
        return mRootView;
    }

    @Override
    public Bundle getViewState() {
        Bundle args = new Bundle(2);
        args.putString("student_id", mLoginId.getText().toString());
        args.putString("student_psw", mLoginPsw.getText().toString());
        return args;
    }
}
