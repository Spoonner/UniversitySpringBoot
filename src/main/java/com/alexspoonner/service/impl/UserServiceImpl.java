package com.alexspoonner.service.impl;

import com.alexspoonner.dao.StudentDao;
import com.alexspoonner.dao.TeacherDao;
import com.alexspoonner.service.UserService;
import com.alexspoonner.utils.AdminCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by spoonner on 7/6/17.
 */
@Service
public class UserServiceImpl implements UserService {

    private final String TEACHER_ROLE = "teacher";
    private final String STUDENT_ROLE = "student";
    private final String ADMIN_ROLE = "admin";
    private final String NO_ROLE = "norole";

    private StudentDao studentDao;
    private TeacherDao teacherDao;

    public StudentDao getStudentDao() {
        return studentDao;
    }

    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public TeacherDao getTeacherDao() {
        return teacherDao;
    }

    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    public String getRole(String email, String password) {
        if (studentDao.findStudentByEmailAndPassword(email, password) != null)
            return STUDENT_ROLE;
        else if (teacherDao.findTeacherByEmailAndPassword(email, password) != null)
            return TEACHER_ROLE;
        else if (AdminCredentials.isAdmin(email, password))
            return ADMIN_ROLE;
        else
            return NO_ROLE;
    }
}
