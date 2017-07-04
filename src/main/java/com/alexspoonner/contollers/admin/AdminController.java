package com.alexspoonner.contollers.admin;

import com.alexspoonner.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by spoonner on 7/4/17.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private MarkDao markDao;
    @Autowired
    private GroupDao groupDao;
    @Autowired
    private ScheduleDao scheduleDao;
    @Autowired
    private SubjectDao subjectDao;
    @Autowired
    private TeacherDao teacherDao;

    @RequestMapping(value = "/", method = GET)
    public String index() {
        return "adminPage";
    }

}
