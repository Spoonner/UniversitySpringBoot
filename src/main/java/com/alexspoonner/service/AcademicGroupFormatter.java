package com.alexspoonner.service;

import com.alexspoonner.dao.GroupDao;
import com.alexspoonner.model.AcademicGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Locale;

/**
 * Created by spoonner on 7/8/17.
 */
@Service
public class AcademicGroupFormatter implements Formatter<AcademicGroup> {

    private GroupDao groupDao;

    @Autowired
    public void setGroupDao(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @Override
    public AcademicGroup parse(String text, Locale locale) throws ParseException {
        //getting id of group record in DB
        Long id = Long.parseLong(text);
        return groupDao.findOne(id);
    }

    @Override
    public String print(AcademicGroup object, Locale locale) {
        return (object != null ? object.getGroupId().toString() : "");
    }
}
