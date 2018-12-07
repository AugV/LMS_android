package com.vainius.augustinas.lms_android.answers;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.vainius.augustinas.lms_android.R;
import com.vainius.augustinas.lms_android.entities.CompletedTask;

public class AnswersViewMVCImpl implements AnswersViewMVC {

    View mRootView;
    TextView mTxtAnswer;
    TextView mTxtSubmissionDate;
    TextView mTxtGrade;
    TextView mTxtGradeDate;

    public AnswersViewMVCImpl(LayoutInflater inflater, ViewGroup container) {
        this.mRootView = inflater.inflate(R.layout.mvc_view_completed_task_page_review, container);
        mTxtAnswer = mRootView.findViewById(R.id.txtAnswer);
        mTxtSubmissionDate = mRootView.findViewById(R.id.txtSubmissionDate);
        mTxtGrade = mRootView.findViewById(R.id.txtGrade);
        mTxtGradeDate = mRootView.findViewById(R.id.txtGradeDate);

    }

    @Override
    public void bindAnswer(CompletedTask complTask) {
        mTxtAnswer.setText(complTask.getAnswer());
        mTxtSubmissionDate.setText(complTask.getSubmissionDate());

        if (complTask.getGradeDate() != null) {
            mTxtGrade.setBackgroundColor(Color.GREEN);
            mTxtGrade.setText(complTask.getGrade());
            mTxtGradeDate.setText(complTask.getGradeDate());
        } else {
            mTxtGrade.setBackgroundColor(Color.RED);
            mTxtGrade.setText("Not graded yet");
            mTxtGradeDate.setText("Not graded yet");
        }
    }

    @Override
    public View getRootView() {
        return mRootView;
    }

    @Override
    public Bundle getViewState() {
        return null;
    }
}
