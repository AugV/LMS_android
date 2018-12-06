package com.vainius.augustinas.lms_android.tasks;

import com.vainius.augustinas.lms_android.common.ViewMVC;
import com.vainius.augustinas.lms_android.entities.Task;

import java.util.List;

public interface TaskPageViewMVC extends ViewMVC {

    interface TaskPageViewMVCListener{
        void onTaskClicked(int id);
    }

    void bindTasks(List<Task> tasks);

    void setListener(TaskPageViewMVCListener listener);
}
