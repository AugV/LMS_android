package com.vainius.augustinas.lms_android.answers;

import com.vainius.augustinas.lms_android.common.ViewMVC;
import com.vainius.augustinas.lms_android.entities.CompletedTask;

public interface AnswersViewMVC extends ViewMVC {
    void bindAnswer(CompletedTask task);
}
