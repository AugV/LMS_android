package com.vainius.augustinas.lms_android.courses;

import com.vainius.augustinas.lms_android.common.ViewMVC;
import com.vainius.augustinas.lms_android.entities.Course;

import java.util.List;

public interface CoursePageViewMVC extends ViewMVC {

    interface CourseListViewListener{
        void onCourseClicked(int id);
    }

    void bindCourses(List<Course> courses);

    void setListener(CourseListViewListener listener);
}
