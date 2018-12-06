package com.vainius.augustinas.lms_android.common;

import android.app.Activity;
import android.app.Application;

import com.vainius.augustinas.lms_android.entities.Course;
import com.vainius.augustinas.lms_android.util.StudentInfoListener;

import java.util.List;

public class SubApplication extends Application implements StudentInfoListener {
    private int studentId;

    public int getStudentId() {
        return studentId;
    }

    private void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public List<Course> getStudentCourseList() {
        return studentCourseList;
    }

    private void setStudentCourseList(List<Course> studentCourseList) {
        this.studentCourseList = studentCourseList;
    }

    private List<Course> studentCourseList;


    public int getId() {
        return studentId;
    }

    public void setId(int id) {
        this.studentId = id;
    }

    @Override
    public void studentIdFetched(int id) {
        setStudentId(id);
    }

    @Override
    public void studentCoursesFetched(List<Course> courses) {
        setStudentCourseList(courses);
    }
}
