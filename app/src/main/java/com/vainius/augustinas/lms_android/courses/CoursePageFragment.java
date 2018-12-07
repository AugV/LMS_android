package com.vainius.augustinas.lms_android.courses;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vainius.augustinas.lms_android.common.BaseFragment;
import com.vainius.augustinas.lms_android.common.PseudoCache;
import com.vainius.augustinas.lms_android.tasks.TaskPageFragment;
import com.vainius.augustinas.lms_android.util.Cache;
import com.vainius.augustinas.lms_android.util.Database;

public class CoursePageFragment extends BaseFragment implements CoursePageViewMVC.CourseListViewListener {

    private CoursePageViewMVC mViewMVC;
    //private PseudoDatabase mEntityManager;
    private int mStudentId;
    private Cache mCache;
    private Database mDatabase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        //mEntityManager = new PseudoDatabase();
        mCache = ((PseudoCache) getContext().getApplicationContext());
        mDatabase = ((PseudoCache) getContext().getApplicationContext());
        mViewMVC = new CoursePageViewMVCImpl(inflater, container);
        mViewMVC.setListener(this);

        Bundle loginInformation = getArguments();
        mStudentId = Integer.parseInt(loginInformation.getString("student_id"));

        mCache.studentFetched(mDatabase.querryDatabase().getStudentById(mStudentId));
        mCache.studentCoursesFetched(mDatabase.querryDatabase().getStudentsCoursesById(mStudentId));

        return mViewMVC.getRootView();
    }

    @Override
    public void onStart() {
        super.onStart();
        mViewMVC.bindCourses(mDatabase.querryDatabase().getStudentsCoursesById(mStudentId));
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
