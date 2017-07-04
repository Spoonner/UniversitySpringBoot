package com.alexspoonner.model;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.*;

/**
 * Persistence class for the 'groups' table
 */

@Entity
@Table(name = "group")
public class Group {

    @Id
    @Column(name = "group_id")
    @GeneratedValue
    private Long groupId;

    @Column(name = "count_of_students")
    private Integer countOfStudents;

    @Column(name = "course_number")
    private Integer courseNumber;

    @Column(name = "group_number")
    //Only number values for the field
    private Integer groupNumber;

    @Column(name = "specialization")
    private String specialization;

    @OneToMany(mappedBy = "group", cascade = ALL, fetch = LAZY)
    private List<Schedule> schedules;

    @OneToMany(mappedBy = "group", cascade = ALL, fetch = LAZY)
    private List<Student> students;

    public Group() {

    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Integer getCountOfStudents() {
        return countOfStudents;
    }

    public void setCountOfStudents(Integer countOfStudents) {
        this.countOfStudents = countOfStudents;
    }

    public Integer getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(Integer courseNumber) {
        this.courseNumber = courseNumber;
    }

    public Integer getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(Integer groupNumber) {
        this.groupNumber = groupNumber;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + groupId +
                ", countOfStudents=" + countOfStudents +
                ", courseNumber=" + courseNumber +
                ", groupNumber=" + groupNumber +
                ", specialization='" + specialization + '\'' +
                '}';
    }
}
