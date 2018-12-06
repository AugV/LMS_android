package com.vainius.augustinas.lms_android.tasks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.vainius.augustinas.lms_android.R;
import com.vainius.augustinas.lms_android.entities.Task;

import java.util.List;

public class TaskPageViewMVCImpl implements TaskPageViewMVC {

    View mRootView;
    ListView mListView;
    TaskPageViewMVCListener mListener;

    public TaskPageViewMVCImpl(LayoutInflater inflater, ViewGroup container) {
        mRootView = inflater.inflate(R.layout.mvc_view_task_page, container, false);
        mListView = (ListView)mRootView.findViewById(R.id.list_tasks);
        //TODO mListView.setAdapter

    }

    @Override
    public void bindTasks(List<Task> tasks) {

    }

    @Override
    public void setListener(TaskPageViewMVCListener listener) {

    }

    @Override
    public View getRootView() {
        return null;
    }

    @Override
    public Bundle getViewState() {
        return null;
    }
}
