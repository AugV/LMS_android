package com.vainius.augustinas.lms_android.util;

import com.vainius.augustinas.lms_android.entities.Course;
import com.vainius.augustinas.lms_android.entities.Student;
import com.vainius.augustinas.lms_android.entities.Task;

import java.util.List;

public interface Cache {

    void studentFetched(Student student);

    void studentCoursesFetched(List<Course> courses);

    void selectedCourseFetched(Course course);

    void selectedTaskFetched(Task task);

    Student getStudent();

    List<Course> getStudentCourses();

    Course getSelectedCourse();

    Task getSelectedTask();




}
