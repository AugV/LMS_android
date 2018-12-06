package com.vainius.augustinas.lms_android.courses;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.vainius.augustinas.lms_android.R;
import com.vainius.augustinas.lms_android.entities.Course;

import java.util.List;

public class CoursePageViewMVCImpl implements CoursePageViewMVC {

    private View mRootView;
    private ListView mListView;
    private CourseListAdapter mCourseListAdapter;
    private CourseListViewListener mListener;

    public CoursePageViewMVCImpl(LayoutInflater inflater, ViewGroup container) {
        mRootView = inflater.inflate(R.layout.mvc_view_course_page, container, false);
        mCourseListAdapter = new CourseListAdapter(inflater.getContext(), 0);
        mListView = (ListView) mRootView.findViewById(R.id.list_courses);
        mListView.setAdapter(mCourseListAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (mListener != null) {
                    mListener.onCourseClicked(mCourseListAdapter.getItem(position).getId());
                }
            }
        });
    }

    @Override
    public void bindCourses(List<Course> courses) {
        mCourseListAdapter.clear();
        mCourseListAdapter.addAll(courses);
    }

    @Override
    public void setListener(CourseListViewListener listener) {
        mListener = listener;
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