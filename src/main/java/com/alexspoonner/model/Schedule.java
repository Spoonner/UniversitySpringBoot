package com.alexspoonner.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.*;
import static javax.persistence.TemporalType.*;

/**
 * Persistence class for 'schedule' table
 */

@Entity
@Table (name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "schedule_id")
    private Long scheduleId;

    @Column(name = "date", nullable = false)
    @Temporal(DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date date;

    @Column(name = "room_number", nullable = false)
    private Integer roomNumber;

    @Column(name = "lesson_number", nullable = false)
    private Integer lessonNumber;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private AcademicGroup academicGroup;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    public Schedule() {

    }

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getLessonNumber() {
        return lessonNumber;
    }

    public void setLessonNumber(Integer lessonNumber) {
        this.lessonNumber = lessonNumber;
    }

    public AcademicGroup getAcademicGroup() {
        return academicGroup;
    }

    public void setAcademicGroup(AcademicGroup academicGroup) {
        this.academicGroup = academicGroup;
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
        return "Schedule{" +
                "scheduleId=" + scheduleId +
                ", date=" + date +
                ", roomNumber=" + roomNumber +
                ", lessonNumber=" + lessonNumber +
                ", academicGroup=" + academicGroup.getGroupNumber() +
                ", subject=" + subject.getName() +
                ", teacher=" + teacher.getFirstName() +
                '}';
    }
}
