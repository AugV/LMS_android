package entities;

import java.util.ArrayList;

public class Teacher extends Person {
    private ArrayList<Course> teacherCourses = new ArrayList();

    public Teacher(int loc_id, String loc_name, String loc_surname) {
        super(loc_id, loc_name, loc_surname);
    }

    public ArrayList<Course> getTeacherCourses() {
        return teacherCourses;
    }

    public void addTeacherCourses(Course course) {
            teacherCourses.add(course);
    }

    @Override
    public String toString() {
        return "ID: " + this.getId() +
                ", Name: " + this.getName() +
                ", Surname: " + this.getSurname() +
                " entities.Teacher{" +
                " teacherCourses= " + teacherCourses +
                '}';
    }
}
