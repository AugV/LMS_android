package com.vainius.augustinas.lms_android.entities;

import com.vainius.augustinas.lms_android.entities.*;

import java.util.List;

public class PseudoDatabase {

    University university;

    public PseudoDatabase() {
        initialize();
    }

    private void initialize() {
        university = new University(1, "VGTU");
        university.addTeacher(1, "Tadas", "jablinksis");
        university.addTeacher(2, "Laimonas", "Stanislovsksi");

        university.addGroup(1, "GRUPE1");
        university.addGroup(2, "GRUPE2");

        university.getGroupByID(1).addGroupStudents(new Student(1, "Petras", "Studentauskas"));
        university.getGroupByID(2).addGroupStudents(new Student(2, "Studenis", "Studavicius"));

        university.addCourse(new Course(
                1, "matematika", "Matematikos kursas", university.getTeacherByID(1), university.getGroupByID(2)));
        university.addCourse(new Course(
                2, "darbaiXD", "Darbuko salalai", university.getTeacherByID(2), university.getGroupByID(1)));
        university.addCourse(new Course(
                3, "darkoks velnias", "dar vienas niekam nereikalingas kursas", university.getTeacherByID(1), university.getGroupByID(2)));

        Task task1 = new Task(1, "primasTaskas", "ejozaselse per ezereli", "08-09", "5");
        university.getCourseByID(1).addCourseTask(task1);

        Task task2 = new Task(2, "antrasTaskas", "ezerelis ejo per zaselse", "12-12", "1");
        university.getCourseByID(2).addCourseTask(task2);


        university.getCourseByID(1).getCourseTaskByID(1).addTaskCompletedTask(new CompletedTask(
                1, "teisingas atsakymas, kolegos", university.getGroupByID(2).getGroupStudents().get(0)));
        university.getCourseByID(2).getCourseTaskByID(2).addTaskCompletedTask(new CompletedTask(
                2, "neteisingas atsakymas, biciuli", university.getGroupByID(1).getGroupStudents().get(0)));
        university.getCourseByID(1).getCourseTaskByID(1).getTaskCompletedTasks().get(0).setGrade("10");
        university.getCourseByID(2).getCourseTaskByID(2).getTaskCompletedTasks().get(0).setGrade("2");
    }

    public List<Course> getStudentsCoursesById(int studentsId) {
        for (Student student : university.getAllStudents()) {
            if (student.getId() == studentsId) {
                return student.getStudentsGroup().getGroupCourses();
            }
        }
        return null;
    }

    public Student getStudentById(int id) {
        for (Student student : university.getAllStudents()) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public CompletedTask getStudentsCompletedTask(Course selectedCourse, Student student, Task selectedTask) {
            for (Task task : selectedCourse.getCourseTasks()) {
                if (task == selectedTask) {
                    for (CompletedTask complTask :
                            task.getTaskCompletedTasks()) {
                        if (complTask.getOwner() == student) {
                            return complTask;
                        }
                    }
                }
            }
        return null;
    }


    public University getUniversityWithData() {
        return university;
    }
}