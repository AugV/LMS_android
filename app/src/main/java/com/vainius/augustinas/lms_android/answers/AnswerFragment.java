package com.vainius.augustinas.lms_android.answers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.vainius.augustinas.lms_android.common.BaseFragment;
import com.vainius.augustinas.lms_android.common.PseudoCache;
import com.vainius.augustinas.lms_android.util.Cache;
import com.vainius.augustinas.lms_android.util.Database;

public class AnswerFragment extends BaseFragment {

    AnswerViewMVC mViewMVC;
    int taskId;
    private Database mDatabase;
    private Cache mCache;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle args) {
        mViewMVC = new AnswerViewMVCImpl(inflater, container);
        mDatabase = ((PseudoCache) getContext().getApplicationContext());
        mCache = ((PseudoCache) getContext().getApplicationContext());

        Bundle taskInfo = getArguments();
        taskId = taskInfo.getInt("task_id");


        return mViewMVC.getRootView();
    }

    @Override
    public void onStart() {
        super.onStart();
        mViewMVC.bindAnswer(mDatabase.querryDatabase().getStudentsCompletedTask(
                mCache.getStudent(),
                mCache.getSelectedTask()));
    }



}
//TODO
// 1. Make SUBMIT ANSWER page
// 2. Make Authentication
// 3. Adjust Answer Display
// 4. Make Task colors depending on completed/graded/niggarded
// TODO