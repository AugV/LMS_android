package com.vainius.augustinas.lms_android.answers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.vainius.augustinas.lms_android.common.BaseFragment;
import com.vainius.augustinas.lms_android.common.PseudoCache;
import com.vainius.augustinas.lms_android.entities.Task;
import com.vainius.augustinas.lms_android.util.Cache;
import com.vainius.augustinas.lms_android.util.Database;

public class AnswersFragment extends BaseFragment {

    AnswersViewMVC mViewMVC;
    int taskId;
    private Database mDatabase;
    private Cache mCache;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle args) {
        mViewMVC = new AnswersViewMVCImpl(inflater, container);
        mDatabase = ((PseudoCache) getContext().getApplicationContext());
        mCache = ((PseudoCache) getContext().getApplicationContext());

        Bundle taskInfo = getArguments();
        taskId = taskInfo.getInt("taskId");
        cacheSelectedTask(taskId);


        return mViewMVC.getRootView();
    }

    @Override
    public void onStart() {
        super.onStart();
        mViewMVC.bindAnswer(mDatabase.querryDatabase().getStudentsCompletedTask(mCache.getSelectedCourse(),
                mCache.getStudent(),
                mCache.getSelectedTask()));
    }

    private void cacheSelectedTask(int taskId) {
        for (Task task : mCache.getSelectedCourse().getCourseTasks()) {
            if(task.getId()==taskId){
                mCache.selectedTaskFetched(task);
            }
        }
    }

}
