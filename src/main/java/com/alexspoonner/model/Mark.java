package com.alexspoonner.model;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.TemporalType.DATE;

/**
 * Persistence class for 'mark' table
 */

@Entity
@Table(name = "mark")
public class Mark {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "mark_id")
    private Long markId;

    @Column(name = "date", nullable = false)
    @Temporal(DATE)
    private Date date;

    @Column(name = "mark_value", nullable = false)
    private float value;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
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
