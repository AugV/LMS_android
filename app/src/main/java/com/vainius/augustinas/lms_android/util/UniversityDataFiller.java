package util;


import entities.University;

public class UniversityDataFiller {

    University university;

    public UniversityDataFiller() {
        university = new University(1, "VGTU");
        university.addTeacher(1,"Tadas", "jablinksis");
        university.addTeacher(2,"Laimonas", "Stanislovsksi");

        university.addGroup(1,"GRUPE1");
        university.addGroup(2,"GRUPE2");

        university.getGroupByID(1).addGroupStudents(new entities.Student(1, "Petras", "Studentauskas"));
        university.getGroupByID(2).addGroupStudents(new entities.Student(2, "Studenis", "Studavicius"));

        university.addCourse(new entities.Course(
                1,"matematika", "Matematikos kursas", university.getTeacherByID(1), university.getGroupByID(2)));
        university.addCourse(new entities.Course(
                2,"darbaiXD", "Darbuko salalai", university.getTeacherByID(2), university.getGroupByID(1)));
        university.addCourse(new entities.Course(
                3,"darkoks velnias", "dar vienas niekam nereikalingas kursas", university.getTeacherByID(1), university.getGroupByID(2)));

        entities.Task task1 = new entities.Task(1,"primasTaskas", "ejozaselse per ezereli", "08-09", "5" );
        university.getCourseByID(1).addCourseTask(task1);

        entities.Task task2 = new entities.Task(2,"antrasTaskas", "ezerelis ejo per zaselse", "12-12", "1");
        university.getCourseByID(2).addCourseTask(task2);


        university.getCourseByID(1).getCourseTaskByID(1).addTaskCompletedTask(new entities.CompletedTask(
                1, "teisingas atsakymas, kolegos", university.getGroupByID(2).getGroupStudents().get(0)));
        university.getCourseByID(2).getCourseTaskByID(2).addTaskCompletedTask(new entities.CompletedTask(
                2, "neteisingas atsakymas, biciuli",university.getGroupByID(1).getGroupStudents().get(0)));
        university.getCourseByID(1).getCourseTaskByID(1).getTaskCompletedTasks().get(0).setGrade("10");
        university.getCourseByID(2).getCourseTaskByID(2).getTaskCompletedTasks().get(0).setGrade("2");

    }

    public University getUniversityWithData(){
        return university;
    }


}
