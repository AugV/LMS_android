package com.vainius.augustinas.lms_android.submit_answer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.vainius.augustinas.lms_android.common.BaseFragment;
import com.vainius.augustinas.lms_android.common.PseudoCache;
import com.vainius.augustinas.lms_android.util.Cache;
import com.vainius.augustinas.lms_android.util.Database;

public class SubmitAnswerFragment extends BaseFragment implements SubmitAnswerViewMVC.SubmitAnswerViewMVCListener {

    SubmitAnswerViewMVC mViewMVC;
    Database mDatabase;
    Cache mCache;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        mViewMVC = new SubmitAnswerViewMVCImpl(inflater, container);
        mViewMVC.setListener(this);
        mDatabase = ((PseudoCache) getContext().getApplicationContext());
        mCache = ((PseudoCache) getContext().getApplicationContext());
        return mViewMVC.getRootView();
    }


    @Override
    public void onSubmitClicked(String answer) {
        mDatabase.querryDatabase().addCompletedTask(mCache.getSelectedTask(), mCache.getStudent(), answer);
        getFragmentManager().popBackStack();

    }
}
