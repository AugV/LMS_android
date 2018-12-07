package com.vainius.augustinas.lms_android.common;

import android.app.Application;

import com.vainius.augustinas.lms_android.entities.Course;
import com.vainius.augustinas.lms_android.entities.PseudoDatabase;
import com.vainius.augustinas.lms_android.entities.Student;
import com.vainius.augustinas.lms_android.entities.Task;
import com.vainius.augustinas.lms_android.util.Cache;
import com.vainius.augustinas.lms_android.util.Database;

import java.util.List;

public class PseudoCache extends Application implements Cache, Database {

    public PseudoDatabase pseudoDataBase;

    private Student student;
    private List<Course> studentCourseList;
    private Course selectedCourse;
    private Task selectedTask;

    @Override
    public void onCreate() {
        super.onCreate();
        pseudoDataBase = new PseudoDatabase();
    }

    @Override
    public PseudoDatabase querryDatabase() {
        return pseudoDataBase;
    }

    @Override
    public void studentFetched(Student student) {
        setStudent(student);
    }

    private void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public void studentCoursesFetched(List<Course> courses) {
        setStudentCourseList(courses);
    }

    private void setStudentCourseList(List<Course> studentCourseList) {
        this.studentCourseList = studentCourseList;
    }

    @Override
    public void selectedCourseFetched(Course course) {
        setSelectedCourse(course);
    }

    @Override
    public void selectedTaskFetched(Task task) {
        setSelectedTask(task);
    }

    @Override
    public Student getStudent() {
        return student;
    }

    private void setSelectedTask(Task task) {
        selectedTask = task;
    }

    private void setSelectedCourse(Course course) {
        selectedCourse = course;
    }

    @Override
    public List<Course> getStudentCourses() {
        return studentCourseList;
    }

    @Override
    public Course getSelectedCourse() {
        return selectedCourse;
    }

    @Override
    public Task getSelectedTask() {
        return selectedTask;
    }

}
