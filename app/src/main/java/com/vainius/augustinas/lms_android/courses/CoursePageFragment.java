package com.vainius.augustinas.lms_android.courses;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.vainius.augustinas.lms_android.common.BaseFragment;
import com.vainius.augustinas.lms_android.entities.Course;
import com.vainius.augustinas.lms_android.entities.EntityManager;

import java.util.List;

public class CoursePageFragment extends BaseFragment implements CoursePageViewMVC.CourseListViewListener {

    CoursePageViewMVC mViewMVC;
    EntityManager mEntityManager;
    int mStudentId;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        mEntityManager =new EntityManager();
        mViewMVC = new CoursePageViewMVCImpl(inflater, container);
        mViewMVC.setListener(this);
        Bundle args = getArguments();
        System.out.println(args.getString("student_id"));
        mStudentId = Integer.parseInt(args.getString("student_id"));
        return mViewMVC.getRootView();
    }

    @Override
    public void onStart() {
        super.onStart();
        mViewMVC.bindCourses(mEntityManager.getStudentsCoursesById(mStudentId));
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onCourseClicked(int id) {
    }
}
