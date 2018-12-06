package com.vainius.augustinas.lms_android.tasks;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.vainius.augustinas.lms_android.R;
import com.vainius.augustinas.lms_android.entities.Task;

public class TaskThumbnailMVCImpl implements TaskThumbnailViewMVC {

    View mRootView;
    TextView mTxtId;
    TextView mTxtName;

    public TaskThumbnailMVCImpl(Context context, ViewGroup container) {
        this.mRootView = LayoutInflater.from(context)
                .inflate(R.layout.mvc_view_task_thumbnail, container, false);

    }

    @Override
    public void bindTask(Task task) {
        mTxtId.setText(String.valueOf(task.getId()));
        mTxtName.setText(task.getName());
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
