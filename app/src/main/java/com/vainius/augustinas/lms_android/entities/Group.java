package entities;


import java.io.Serializable;
import java.util.ArrayList;

public class Group extends Entity implements Serializable {

    ArrayList<Student> groupStudents = new ArrayList();
    ArrayList<Course> groupCourses = new ArrayList();


    public void addGroupCourse(Course groupCourse) {
            this.groupCourses.add(groupCourse);
    }

    public Group(int id, String name) {
        super(id, name);
    }

    public ArrayList<Student> getGroupStudents() {
        return groupStudents;
    }

    public void addGroupStudents(Student student) {
        student.setStudentsGroup(this);
        this.groupStudents.add(student);
    }

    public ArrayList<Course> getGroupCourses() {
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
