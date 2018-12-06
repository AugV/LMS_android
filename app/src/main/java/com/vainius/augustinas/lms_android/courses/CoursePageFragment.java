package com.vainius.augustinas.lms_android.courses;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vainius.augustinas.lms_android.common.BaseFragment;
import com.vainius.augustinas.lms_android.common.SubApplication;
import com.vainius.augustinas.lms_android.entities.EntityManager;
import com.vainius.augustinas.lms_android.tasks.TaskPageFragment;
import com.vainius.augustinas.lms_android.util.StudentInfoListener;

public class CoursePageFragment extends BaseFragment implements CoursePageViewMVC.CourseListViewListener {

    CoursePageViewMVC mViewMVC;
    EntityManager mEntityManager;
    int mStudentId;
    StudentInfoListener mStudentInfoListener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        mEntityManager =new EntityManager();

        mViewMVC = new CoursePageViewMVCImpl(inflater, container);
        mViewMVC.setListener(this);

        Bundle args = getArguments();
        mStudentId = Integer.parseInt(args.getString("student_id"));

        mStudentInfoListener = ((SubApplication)getContext());
        mStudentInfoListener.studentIdFetched(Integer.parseInt(args.getString("student_id")));
        mStudentInfoListener.studentCoursesFetched(mEntityManager.getStudentsCoursesById(mStudentId));

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
        Bundle courseInfo = new Bundle(1);
        courseInfo.putInt("course_id", id);
        replaceFragment(TaskPageFragment.class, true, courseInfo);
    }

}
