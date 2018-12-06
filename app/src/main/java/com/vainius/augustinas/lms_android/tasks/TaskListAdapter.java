package com.vainius.augustinas.lms_android.tasks;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.vainius.augustinas.lms_android.entities.Task;

public class TaskListAdapter extends ArrayAdapter<Task> {

    public TaskListAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TaskThumbnailViewMVC taskThumbnailViewMVC;

        if (convertView == null) {
            taskThumbnailViewMVC = new TaskThumbnailViewMVCImpl(getContext(), parent);
            taskThumbnailViewMVC.getRootView().setTag(taskThumbnailViewMVC);
        } else {
            taskThumbnailViewMVC = ((TaskThumbnailViewMVC) convertView.getTag());
        }
        taskThumbnailViewMVC.bindTask(getItem(position));
        return taskThumbnailViewMVC.getRootView();
    }
}
