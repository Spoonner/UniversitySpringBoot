package com.alexspoonner.contollers.admin;

import com.alexspoonner.dao.*;
import com.alexspoonner.model.*;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by spoonner on 7/4/17.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    private StudentDao studentDao;
    private MarkDao markDao;
    private GroupDao groupDao;
    private ScheduleDao scheduleDao;
    private SubjectDao subjectDao;
    private TeacherDao teacherDao;

    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Autowired
    public void setMarkDao(MarkDao markDao) {
        this.markDao = markDao;
    }

    @Autowired
    public void setGroupDao(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @Autowired
    public void setScheduleDao(ScheduleDao scheduleDao) {
        this.scheduleDao = scheduleDao;
    }

    @Autowired
    public void setSubjectDao(SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }

    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @RequestMapping(value = "", method = GET)
    public String index(Model model, HttpServletRequest request) {
        /**
         * Make sure you can't get to /admin without 'who' cookie set to 'admin'
         */
        boolean isAllowed = false;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("who") && cookie.getValue().equals("admin"))
                isAllowed = true;
        }
        if (!isAllowed)
           //redirect to error page
            return "redirect:/error";
        /**
         * fetch all values from DB and show adminPage
         */
        List<Student> students = studentDao.findAllByOrderByLastName();
        List<Teacher> teachers = teacherDao.findAllByOrderByLastName();
        List<Mark> marks = markDao.findALlByOrderByDateDesc();
        List<Schedule> schedules = scheduleDao.findAllByOrderByDateDesc();
        List<Subject> subjects = subjectDao.findAllByOrderByName();
        List<AcademicGroup> groups = groupDao.findAllByOrderByCourseNumber();
        model.addAttribute("students", students);
        model.addAttribute("groups", groups);
        model.addAttribute("marks", marks);
        model.addAttribute("teachers", teachers);
        model.addAttribute("schedules", schedules);
        model.addAttribute("subjects", subjects);
        model.addAttribute("title", "Админка");
        return "adminPage";
    }

}
