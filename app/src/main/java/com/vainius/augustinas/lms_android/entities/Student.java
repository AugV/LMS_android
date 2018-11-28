package entities;

public class Student extends Person {
    private Group studentsGroup;


    public Student(int loc_id, String loc_name, String loc_surname) {
        super(loc_id, loc_name, loc_surname);
    }


    public Group getStudentsGroup() {
        return studentsGroup;
    }

    public void setStudentsGroup(Group studentsGroup) {
        this.studentsGroup = studentsGroup;
    }

    @Override
    public String toString() {
        return "entities.Student{" +
                "ID: " + getId() +
                ", Name: " + getName() +
                ", Surname: " + getSurname() +
                '}';
    }

}
