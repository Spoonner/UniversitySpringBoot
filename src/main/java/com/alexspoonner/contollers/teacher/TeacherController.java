package com.alexspoonner.contollers.teacher;

import com.alexspoonner.dao.TeacherDao;
import com.alexspoonner.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by spoonner on 7/4/17.
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {
    private TeacherDao teacherDao;

    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @RequestMapping(value = "/add", method = GET)
    public String showAddForm(Model model) {
        model.addAttribute("teacher", new Teacher());
        model.addAttribute("title", "Добавить преподавателя");
        model.addAttribute("back", "/admin");
        return "addTeacher";
    }

    @RequestMapping(value = {"/add", "/edit"}, method = POST)
    public String proceedAddingTeacher(@ModelAttribute(name = "teacher")Teacher teacher) {
        teacherDao.save(teacher);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/edit", method = GET)
    public String showEditForm(@RequestParam("id") String id, Model model) {
        model.addAttribute("title", "Изменить информацию о преподаватели");
        model.addAttribute("back", "/admin");
        model.addAttribute("teacher", teacherDao.findOne(Long.parseLong(id)));
        return "addTeacher";
    }

    @RequestMapping(value = "/delete", method = GET)
    public String proceedDeletingTeacher(@RequestParam("id") String id) {
        teacherDao.delete(Long.parseLong(id));
        return "redirect:/admin";
    }

    @RequestMapping(value = "/personal_info", method = GET)
    public String showPersonalInfo(HttpServletRequest request, Model model) {
        Long teacherId = null;
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("teacherId")) {
                teacherId = Long.parseLong(cookie.getValue());
            }
        }
        Teacher teacher = teacherDao.findOne(teacherId);
        model.addAttribute("teacher", teacher);
        model.addAttribute("schedules", teacher.getSchedules());
        model.addAttribute("marks", teacher.getMarks());
        return "teacherPage";
    }

    @RequestMapping(value = "/addMarkTeacher", method = GET)
    public String showAddMarkForm(Model model, @RequestParam("id") String teacherId) {

        return "addMark";
    }
    

}
