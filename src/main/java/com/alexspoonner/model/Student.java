package com.alexspoonner.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.TemporalType.*;

/**
 * Persistence class for 'student' table
 */

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "average_mark")
    private float averageMark;

    @Column(name = "date_birth", nullable = false)
    @Temporal(DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateOfBirth;

    @Column(name = "date_entry")
    @Temporal(DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateOfEntry;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "third_name", nullable = false)
    private String thirdName;

    @Column(name = "form_studies", nullable = false)
    private String formOfStudies;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "scholarship")
    private float scholarshipSize;

    @OneToMany(mappedBy = "student", cascade = ALL, fetch = LAZY)
    private List<Mark> marks;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private AcademicGroup academicGroup;

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

    public AcademicGroup getAcademicGroup() {
        return academicGroup;
    }

    public void setAcademicGroup(AcademicGroup academicGroup) {
        this.academicGroup = academicGroup;
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
                ", academicGroup=" + academicGroup +
                '}';
    }
}
