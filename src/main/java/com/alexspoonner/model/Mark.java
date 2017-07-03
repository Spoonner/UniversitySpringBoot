package com.alexspoonner.model;

import java.util.Date;

/**
 * Created by spoonner on 7/3/17.
 */
public class Mark {
    private Long markId;
    private Date date;
    private float value;
    private Student student;
    private Subject subject;
    private Teacher teacher;

    public Mark() {

    }

    public Long getMarkId() {
        return markId;
    }

    public void setMarkId(Long markId) {
        this.markId = markId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "markId=" + markId +
                ", date=" + date +
                ", value=" + value +
                ", student=" + student +
                ", subject=" + subject +
                ", teacher=" + teacher +
                '}';
    }
}
