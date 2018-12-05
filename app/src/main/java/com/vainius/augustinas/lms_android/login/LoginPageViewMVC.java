package com.vainius.augustinas.lms_android.login;

import com.vainius.augustinas.lms_android.common.ViewMVC;

public interface LoginPageViewMVC extends ViewMVC {

    interface LoginPageViewMVCListener {
        void onLoginButtonClicked(String loginId, String loginPsw);
    }

    void setListener(LoginPageViewMVCListener listener);
}
