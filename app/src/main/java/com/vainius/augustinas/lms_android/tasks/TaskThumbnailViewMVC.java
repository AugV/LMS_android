package com.vainius.augustinas.lms_android.tasks;

import com.vainius.augustinas.lms_android.common.ViewMVC;
import com.vainius.augustinas.lms_android.entities.Task;

public interface TaskThumbnailViewMVC extends ViewMVC {
    void bindTask(Task task);
}
