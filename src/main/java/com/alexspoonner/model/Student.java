package com.alexspoonner.model;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

/**
 * Created by spoonner on 7/3/17.
 */
public class Student {
    private Long studentId;
    private float averageMark;
    private Date dateOfBirth;
    private Date dateOfEntry;
    private String email;
    private String firstName;
    private String lastName;
    private String thirdName;
    private String formOfStudies;
    private String password;
    private float scholarshipSize;
    private List<Mark> marks;
    private Group group;

    public Student() {

    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public float getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(float averageMark) {
        this.averageMark = averageMark;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfEntry() {
        return dateOfEntry;
    }

    public void setDateOfEntry(Date dateOfEntry) {
        this.dateOfEntry = dateOfEntry;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getFormOfStudies() {
        return formOfStudies;
    }

    public void setFormOfStudies(String formOfStudies) {
        this.formOfStudies = formOfStudies;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getScholarshipSize() {
        return scholarshipSize;
    }

    public void setScholarshipSize(float scholarshipSize) {
        this.scholarshipSize = scholarshipSize;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public void setMarks(List<Mark> marks) {
        this.marks = marks;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", averageMark=" + averageMark +
                ", dateOfBirth=" + dateOfBirth +
                ", dateOfEntry=" + dateOfEntry +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", thirdName='" + thirdName + '\'' +
                ", formOfStudies='" + formOfStudies + '\'' +
                ", password='" + password + '\'' +
                ", scholarshipSize=" + scholarshipSize +
                ", group=" + group +
                '}';
    }
}
