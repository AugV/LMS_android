package com.vainius.augustinas.lms_android.submit_answer;

import com.vainius.augustinas.lms_android.common.ViewMVC;

public interface SubmitAnswerViewMVC extends ViewMVC {

    interface SubmitAnswerViewMVCListener{
        void onSubmitClicked(String answer);    }

        void setListener(SubmitAnswerViewMVCListener listener);
        
}
