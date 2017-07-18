package com.alexspoonner.service.impl;

import com.alexspoonner.dao.TeacherDao;
import com.alexspoonner.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Locale;

/**
 * Created by spoonner on 7/8/17.
 */
@Service
public class TeacherFormatter implements Formatter<Teacher> {

    private TeacherDao teacherDao;

    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    public Teacher parse(String text, Locale locale) throws ParseException {
        return teacherDao.getOne(Long.parseLong(text));
    }

    @Override
    public String print(Teacher object, Locale locale) {
        return (object != null ? object.getTeacherId().toString() : "");
    }
}
