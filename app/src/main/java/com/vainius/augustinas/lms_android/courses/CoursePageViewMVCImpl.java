package com.vainius.augustinas.lms_android.courses;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import com.vainius.augustinas.lms_android.entities.Course;

import java.util.List;

public class CoursePageViewMVCImpl implements CoursePageViewMVC{

    private View mRootView;
    private ListView mListView;
    private CourseListViewListener mListener;


    @Override
    public void bindCourses(List<Course> courses) {

    }

    @Override
    public void setListener(CourseListViewListener listener) {

    }

    @Override
    public View getRootView() {
        return null;
    }

    @Override
    public Bundle getViewState() {
        return null;
    }
}
