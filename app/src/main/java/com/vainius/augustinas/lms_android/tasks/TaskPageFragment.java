package com.vainius.augustinas.lms_android.tasks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vainius.augustinas.lms_android.common.BaseFragment;
import com.vainius.augustinas.lms_android.common.SubApplication;
import com.vainius.augustinas.lms_android.entities.Course;
import com.vainius.augustinas.lms_android.entities.EntityManager;
import com.vainius.augustinas.lms_android.entities.Task;
import com.vainius.augustinas.lms_android.util.StudentInfoListener;

import java.util.List;

public class TaskPageFragment extends BaseFragment implements TaskPageViewMVC.TaskPageViewMVCListener {

    private TaskPageViewMVC mViewMvc;
    private StudentInfoListener mStudentInfoListener;
    private int courseId;
    private List<Task> tasks;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        mViewMvc = new TaskPageViewMVCImpl(inflater, container);
        mViewMvc.setListener(this);

        Bundle args = getArguments();
        courseId = args.getInt("course_id");

        setTasks();

        return mViewMvc.getRootView();
    }

    private void setTasks() {
        mStudentInfoListener = ((SubApplication) getContext().getApplicationContext());
        for (Course course : mStudentInfoListener.getStudentCourses()
                ) {
            if (course.getId() == courseId) {
                tasks = course.getCourseTasks();
            }
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        mViewMvc.bindTasks(tasks);
    }

    @Override
    public void onTaskClicked(int id) {

    }
}
