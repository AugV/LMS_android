package com.vainius.augustinas.lms_android.answers;

import com.vainius.augustinas.lms_android.common.ViewMVC;
import com.vainius.augustinas.lms_android.entities.CompletedTask;

public interface AnswerViewMVC extends ViewMVC {
    void bindAnswer(CompletedTask task);
}
