package com.alexspoonner.model;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.*;

/**
 * Persistence class for 'subject' table
 */

@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "subject_id")
    private Long subjectId;

    @Column(name = "number_hours")
    private float numberOfHours;

    @Column(name = "control_form")
    private String formOfControl;

    @Column(name = "subject_name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "subject", cascade = ALL, fetch = LAZY)
    private List<Mark> marks;

    @OneToMany(mappedBy = "subject", cascade = ALL, fetch = LAZY)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subject subject = (Subject) o;

        if (Float.compare(subject.numberOfHours, numberOfHours) != 0) return false;
        if (!subjectId.equals(subject.subjectId)) return false;
        if (formOfControl != null ? !formOfControl.equals(subject.formOfControl) : subject.formOfControl != null)
            return false;
        return name != null ? name.equals(subject.name) : subject.name == null;
    }

    @Override
    public int hashCode() {
        int result = subjectId.hashCode();
        result = 31 * result + (numberOfHours != +0.0f ? Float.floatToIntBits(numberOfHours) : 0);
        result = 31 * result + (formOfControl != null ? formOfControl.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
