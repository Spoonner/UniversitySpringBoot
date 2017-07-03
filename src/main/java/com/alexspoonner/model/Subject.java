package com.alexspoonner.model;

import java.util.List;

/**
 * Created by spoonner on 7/3/17.
 */
public class Subject {
    private Long subjectId;
    private float numberOfHours;
    private String formOfControl;
    private String name;
    private List<Mark> marks;
    private List<Schedule> schedules;

    public Subject() {

    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public float getNumberOfHours() {
        return numberOfHours;
    }

    public void setNumberOfHours(float numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    public String getFormOfControl() {
        return formOfControl;
    }

    public void setFormOfControl(String formOfControl) {
        this.formOfControl = formOfControl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public void setMarks(List<Mark> marks) {
        this.marks = marks;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", numberOfHours=" + numberOfHours +
                ", formOfControl='" + formOfControl + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
