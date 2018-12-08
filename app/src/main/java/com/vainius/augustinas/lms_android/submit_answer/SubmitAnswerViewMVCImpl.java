package com.vainius.augustinas.lms_android.submit_answer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.vainius.augustinas.lms_android.R;

public class SubmitAnswerViewMVCImpl implements SubmitAnswerViewMVC {

    View mRootView;
    EditText mEdtTxtAnswer;
    Button mBtnSubmit;
    SubmitAnswerViewMVCListener mListener;

    public SubmitAnswerViewMVCImpl(LayoutInflater inflater, ViewGroup container) {
        mRootView = inflater.inflate(R.layout.mvc_view_answer_submit, container, false);
        mEdtTxtAnswer= (EditText) mRootView.findViewById(R.id.edtTxtAnswer);
        mBtnSubmit = (Button) mRootView.findViewById(R.id.btnSubmitAnswer);
        mBtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onSubmitClicked(mEdtTxtAnswer.getText().toString());
            }
        });
    }

    @Override
    public View getRootView() {
        return mRootView;
    }

    @Override
    public Bundle getViewState() {
        return null;
    }

    @Override
    public void setListener(SubmitAnswerViewMVCListener listener) {
        mListener = listener;
    }
}
