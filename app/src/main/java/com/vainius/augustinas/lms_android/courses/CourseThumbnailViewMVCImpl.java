package com.vainius.augustinas.lms_android.courses;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.vainius.augustinas.lms_android.R;
import com.vainius.augustinas.lms_android.entities.Course;

public class CourseThumbnailViewMVCImpl implements CourseThumbnailViewMVC {

    private final Context context;
    View mRootView;

    private TextView mTxtId;
    private TextView mTxtName;


    public CourseThumbnailViewMVCImpl(Context context, ViewGroup container) {
        this.context = context;
        mRootView = LayoutInflater.from(context)
                .inflate(R.layout.mvc_view_course_thumbnail, container, false);
        mTxtId=(TextView)mRootView.findViewById(R.id.course_id);
        mTxtName=(TextView)mRootView.findViewById(R.id.course_name);
    }


    @Override
    public void bindCourse(Course course) {
        mTxtId.setText(String.valueOf(course.getId()));
        mTxtName.setText(course.getName());
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
