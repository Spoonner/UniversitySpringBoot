package com.alexspoonner.service.impl;

import com.alexspoonner.dao.GroupDao;
import com.alexspoonner.dao.StudentDao;
import com.alexspoonner.model.AcademicGroup;
import com.alexspoonner.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

/**
 * Created by spoonner on 7/8/17.
 */
public class StudentFormatter implements Formatter<Student> {

    private StudentDao studentDao;

    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public Student parse(String text, Locale locale) throws ParseException {
        Long id = Long.parseLong(text);
        return studentDao.findOne(id);
    }

    @Override
    public String print(Student object, Locale locale) {
        return (object != null ? object.getStudentId().toString() : "");
    }
}
