package com.vainius.augustinas.lms_android.entities;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Group extends Entity implements Serializable {

    List<Student> groupStudents = new ArrayList();
    List<Course> groupCourses = new ArrayList();


    public void addGroupCourse(Course groupCourse) {
            this.groupCourses.add(groupCourse);
    }

    public Group(int id, String name) {
        super(id, name);
    }

    public List<Student> getGroupStudents() {
        return groupStudents;
    }

    public void addGroupStudents(Student student) {
        student.setStudentsGroup(this);
        this.groupStudents.add(student);
    }

    public List<Course> getGroupCourses() {
        return groupCourses;
    }

    @Override
    public String toString() {
        return "entities.Group{" +
                "groupID=" + this.getId() +
                ", name='" + this.getName() + '\'' +
                ", groupStudents=" + groupStudents +
                '}';
    }
}
