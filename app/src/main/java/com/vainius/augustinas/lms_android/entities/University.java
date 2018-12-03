package com.vainius.augustinas.lms_android.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class University extends Entity implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;

    private ArrayList<Teacher> teacherList = new ArrayList();
    private ArrayList<Group> groupList = new ArrayList();
    private ArrayList<Course> courseList = new ArrayList();

    private Group selectedGroup;

    public University(int id, String name) {
        super(id, name);
    }


    public void setSelectedGroup(Object selectedGroup) {
        this.selectedGroup = (Group) selectedGroup;
    }

    public Group getSelectedGroup() {
        return selectedGroup;
    }

    //Groups
    //region
    public ArrayList<Group> getGroupList() {
        return groupList;
    }

    public void addGroup(Group group) {
        groupList.add(group);
    }

    public void addGroup(int id, String name) {
        Group group = new Group(id, name);
        groupList.add(group);
    }

    public Group getGroupByID(int id) {
        for (Group group : this.getGroupList()) {
            if (group.getId() == id) {
                return group;
            }
        }
        return null;
    }

    public void removeGroup(Object groupToRemove) {
        groupList.remove(groupToRemove);
    }

    //endregion
    //Courses
    //region
    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    public void removeCourse(Object courseToRemove) {
        courseList.remove(courseToRemove);
        for (Group group : groupList) {
            group.getGroupCourses().remove(courseToRemove);
        }
        for (Teacher teacher : teacherList) {
            teacher.getTeacherCourses().remove(courseToRemove);
        }
    }

    public void addCourse(Course course) {
        courseList.add(course);
    }

    public Course getCourseByID(int id) {
        Course courseMatch = null;
        for (Course course : this.getCourseList()) {
            if (course.getId() == id) {
                courseMatch = course;
                break;
            }
        }
        return courseMatch;
    }

    //endregion
    //Teachers
    // region
    public ArrayList<Teacher> getTeacherList() {
        return teacherList;
    }

    public void addTeacher(Teacher teacher) {
        this.teacherList.add(teacher);
    }

    public void removeTeacher(Object teacherToRemove) {
        System.out.println("remooving");
        teacherList.remove(teacherToRemove);
    }

    public Teacher getTeacherByID(int id) {
        Teacher teacherMatch = null;
        for (Teacher teacher : this.getTeacherList()) {
            if (teacher.getId() == id) {
                teacherMatch = teacher;
                return teacherMatch;
            }
        }
        //if (teacherMatch==null) throw new IllegalArgumentException(" !entities.Teacher with this ID does not exist!");
        return null;
    }

    public void addTeacher(int id, String name, String surname) {
        Teacher teacher = new Teacher(id, name, surname);
        teacherList.add(teacher);
    }

    public void removeTeacher(Teacher teacherToRemove) {
        try {
            teacherList.remove(teacherToRemove);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(" !entities.Teacher does not exist!");
        }
    }

    //endregion
    //General
    public List<Student> getAllStudents() {
        List<Student> allStudents = new ArrayList<>();
        for (Group group : groupList) {
            allStudents.addAll(group.getGroupStudents());
        }
        return allStudents;
    }

    public Student getStudentById(int studentId) {
        List<Student> studentList = getAllStudents();
        for (Student student : studentList) {
            if (student.getId() == studentId) {
                return student;
            }
        }
        throw new NoSuchElementException("Student not found");
    }
}
