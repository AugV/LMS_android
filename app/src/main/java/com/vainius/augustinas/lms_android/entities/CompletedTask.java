package com.vainius.augustinas.lms_android.entities;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CompletedTask extends Entity implements Serializable  {
    private static DateFormat dateFormat= new SimpleDateFormat("yyyy/mm/dd");
    private static Calendar calendar = Calendar.getInstance();

    private Student owner;

    public Student getOwner() {
        return owner;
    }

    public String getSubmissionDate() {
        return submissionDate;
    }

    public String getGradeDate() {
        return gradeDate;
    }

    private String answer;
    private String grade;
    private String submissionDate;
    private String gradeDate;

    public CompletedTask(int id, String answer, Student owner) {
        super(id);
        this.answer = answer;
        this.submissionDate = dateFormat.format(calendar.getTime());
        this.owner = owner;
    }

    public String getAnswer() {
        return answer;
    }


    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
        this.gradeDate =  dateFormat.format(calendar.getTime());
    }

    @Override
    public String toString() {
        return "entities.CompletedTask{" +
                "answer='" + answer + '\'' +
                ", grade='" + grade + '\'' +
                ", submissionDate='" + submissionDate + '\'' +
                ", gradeDate='" + gradeDate + '\'' +
                '}';
    }
}
