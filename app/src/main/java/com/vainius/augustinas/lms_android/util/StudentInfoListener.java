package com.vainius.augustinas.lms_android.util;

import com.vainius.augustinas.lms_android.entities.Course;

import java.util.List;

public interface StudentInfoListener {
    void studentIdFetched(int id);

    void studentCoursesFetched(List<Course> courses);

    List<Course> getStudentCourses();
}
