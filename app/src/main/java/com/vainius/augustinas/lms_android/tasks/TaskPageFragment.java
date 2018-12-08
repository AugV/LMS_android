package com.vainius.augustinas.lms_android.tasks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vainius.augustinas.lms_android.answers.AnswersFragment;
import com.vainius.augustinas.lms_android.common.BaseFragment;
import com.vainius.augustinas.lms_android.common.PseudoCache;
import com.vainius.augustinas.lms_android.entities.CompletedTask;
import com.vainius.augustinas.lms_android.entities.Course;
import com.vainius.augustinas.lms_android.entities.Task;
import com.vainius.augustinas.lms_android.submit_answer.SubmitAnswerFragment;
import com.vainius.augustinas.lms_android.util.Cache;

import java.util.List;

public class TaskPageFragment extends BaseFragment implements TaskPageViewMVC.TaskPageViewMVCListener {

    private TaskPageViewMVC mViewMvc;
    private Cache mCache;
    private int courseId;
    private List<Task> tasks;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        mViewMvc = new TaskPageViewMVCImpl(inflater, container);
        mViewMvc.setListener(this);

        Bundle args = getArguments();
        courseId = args.getInt("course_id");

        mCache = ((PseudoCache) getContext().getApplicationContext());
        selectedCourseToCache(courseId);
        setTasks();

        return mViewMvc.getRootView();
    }

    private void cacheSelectedTask(int taskId) {
        for (Task task : mCache.getSelectedCourse().getCourseTasks()) {
            if (task.getId() == taskId) {
                mCache.selectedTaskFetched(task);
            }
        }
    }

    private void selectedCourseToCache(int courseId) {
        for (Course course : mCache.getStudentCourses()
        ) {
            if (course.getId() == courseId) {
                mCache.selectedCourseFetched(course);
            }
        }
    }

    private void setTasks() {
        tasks = mCache.getSelectedCourse().getCourseTasks();
    }

    @Override
    public void onStart() {
        super.onStart();
        mViewMvc.bindTasks(tasks);
    }

    @Override
    public void onTaskClicked(int id) {
        cacheSelectedTask(id);

        Bundle taskInfo = new Bundle(1);
        taskInfo.putInt("task_id", id);
        if (answerExists(mCache.getSelectedTask())) {
            replaceFragment(AnswersFragment.class, true, taskInfo);
        } else {replaceFragment(SubmitAnswerFragment.class, true, taskInfo);}
    }

    private boolean answerExists(Task task) {
        for (CompletedTask cmplTask :
                task.getTaskCompletedTasks()) {
            if (cmplTask.getOwner() == mCache.getStudent()) {
                return true;
            }
        }
        return false;
    }
}
