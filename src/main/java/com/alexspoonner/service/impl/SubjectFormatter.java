package com.alexspoonner.service.impl;

import com.alexspoonner.dao.SubjectDao;
import com.alexspoonner.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Locale;

/**
 * Created by spoonner on 7/8/17.
 */
@Service
public class SubjectFormatter implements Formatter<Subject> {

    private SubjectDao subjectDao;

    @Autowired
    public void setSubjectDao(SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }


    @Override
    public Subject parse(String text, Locale locale) throws ParseException {
        return subjectDao.findOne(Long.parseLong(text));
    }

    @Override
    public String print(Subject object, Locale locale) {
        return (object != null ? object.getSubjectId().toString() : "");
    }
}
