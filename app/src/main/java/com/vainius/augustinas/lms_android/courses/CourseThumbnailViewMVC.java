package com.vainius.augustinas.lms_android.courses;

import com.vainius.augustinas.lms_android.common.ViewMVC;
import com.vainius.augustinas.lms_android.entities.Course;

public interface CourseThumbnailViewMVC extends ViewMVC {

    void bindCourse(Course course);
}
