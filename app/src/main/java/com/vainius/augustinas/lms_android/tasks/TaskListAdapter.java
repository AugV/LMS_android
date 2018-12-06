package com.vainius.augustinas.lms_android.tasks;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;
import androidx.annotation.RecentlyNonNull;
import com.vainius.augustinas.lms_android.entities.Task;

public class TaskListAdapter extends ArrayAdapter<Task> {

    public TaskListAdapter(Context context, int resource) {
        super(context, resource);

    }
}
