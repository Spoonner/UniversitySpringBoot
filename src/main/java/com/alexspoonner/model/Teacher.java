package com.alexspoonner.model;


import javax.persistence.*;
import java.util.List;

import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.*;

/**
 * Persistence class for 'teacher' table
 */

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "teacher_id")
    private Long teacherId;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "experience")
    private Integer yearExperience;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "third_name", nullable = false)
    private String thirdName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "position")
    private String position;

    @Column(name = "salary")
    private float salary;

    @OneToMany(mappedBy = "teacher", fetch = LAZY)
    private List<Mark> marks;

    @OneToMany(mappedBy = "teacher", fetch = LAZY)
    private List<Schedule> schedules;

    public Teacher() {

    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getYearExperience() {
        return yearExperience;
    }

    public void setYearExperience(Integer yearExperience) {
        this.yearExperience = yearExperience;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
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
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", email='" + email + '\'' +
                ", yearExperience=" + yearExperience +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", thirdName='" + thirdName + '\'' +
                ", password='" + password + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
