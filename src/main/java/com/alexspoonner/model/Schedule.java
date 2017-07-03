package com.alexspoonner.model;

import java.util.Date;

/**
 * Created by spoonner on 7/3/17.
 */
public class Schedule {

    private Long scheduleId;
    private Date date;
    private Integer roomNumber;
    private Integer number;
    private Group group;
    private Subject subject;
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
