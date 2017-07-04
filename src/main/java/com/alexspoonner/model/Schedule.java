package com.alexspoonner.model;

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

    @Column(name = "date")
    @Temporal(DATE)
    private Date date;

    @Column(name = "room_number")
    private Integer roomNumber;

    @Column(name = "number")
    private Integer number;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
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
                ", number=" + number +
                ", group=" + group.getGroupNumber() +
                ", subject=" + subject.getName() +
                ", teacher=" + teacher.getFirstName() +
                '}';
    }
}
