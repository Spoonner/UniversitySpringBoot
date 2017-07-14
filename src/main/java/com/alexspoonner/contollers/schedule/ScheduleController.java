package com.alexspoonner.contollers.schedule;

import com.alexspoonner.dao.GroupDao;
import com.alexspoonner.dao.ScheduleDao;
import com.alexspoonner.dao.SubjectDao;
import com.alexspoonner.dao.TeacherDao;
import com.alexspoonner.model.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by spoonner on 7/4/17.
 */
@Controller
@RequestMapping("/schedule")
public class ScheduleController {

    private ScheduleDao scheduleDao;
    private TeacherDao teacherDao;
    private SubjectDao subjectDao;
    private GroupDao groupDao;

    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Autowired
    public void setSubjectDao(SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }

    @Autowired
    public void setGroupDao(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @Autowired
    public void setScheduleDao(ScheduleDao scheduleDao) {
        this.scheduleDao = scheduleDao;
    }

    @RequestMapping(value = "/add", method = GET)
    public String showAddForm(Model model) {
        model.addAttribute("title", "Добавить в расписание");
        model.addAttribute("back", "/admin");
        model.addAttribute("schedule", new Schedule());
        model.addAttribute("groups", groupDao.findAll());
        model.addAttribute("subjects", subjectDao.findAll());
        model.addAttribute("teachers", teacherDao.findAll());
        return "addSchedule";
    }

    @RequestMapping(value = "/edit", method = GET)
    public String showEdtiForm(Model model, @RequestParam("id") String id) {
        Schedule scheduleToEdit = scheduleDao.findOne(Long.parseLong(id));
        model.addAttribute("schedule", scheduleToEdit);
        model.addAttribute("groups", groupDao.findAll());
        model.addAttribute("subjects", subjectDao.findAll());
        model.addAttribute("teachers", teacherDao.findAll());
        return "addSchedule";
    }

    @RequestMapping(value = {"/add", "/edit"}, method = POST)
    public String proceedAddingSchedule(@ModelAttribute("schedule") Schedule schedule) {
        scheduleDao.save(schedule);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/delete", method = GET)
    public String proceedDeletingSchedule(@RequestParam("id") String id) {
        scheduleDao.delete(Long.parseLong(id));
        return "redirect:/admin";
    }
}
