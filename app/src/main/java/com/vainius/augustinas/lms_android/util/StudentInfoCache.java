package com.vainius.augustinas.lms_android.util;

import com.vainius.augustinas.lms_android.entities.Course;

import java.util.List;

public class StudentInfoCache implements StudentInfoListener {

    static int studentId;
    static List<Course> studentCourses;

    @Override
    public void studentIdFetched(int id) {
        studentId = id;
    }
}
