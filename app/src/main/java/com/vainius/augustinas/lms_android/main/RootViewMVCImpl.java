package com.vainius.augustinas.lms_android.main;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.vainius.augustinas.lms_android.R;
import com.vainius.augustinas.lms_android.common.ViewMVC;

public class RootViewMVCImpl implements ViewMVC {

    private View mRootView;

    public RootViewMVCImpl(Context context, ViewGroup container){
        mRootView = LayoutInflater.from(context).inflate(R.layout.mvc_view_frame_layout, container);
    }

    //TODO https://github.com/techyourchance/android_mvc_tutorial/blob/master/app/src/main/java/com/techyourchance/www/android_mvc_tutorial/screens/common/mvcviews/RootViewMvcImpl.java

    @Override
    public View getRootView() {
        return mRootView;
    }

    @Override
    public Bundle getViewState() {
        return null;
    }
}
