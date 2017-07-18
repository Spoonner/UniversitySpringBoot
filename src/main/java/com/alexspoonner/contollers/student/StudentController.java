package com.alexspoonner.contollers.student;

import com.alexspoonner.dao.GroupDao;
import com.alexspoonner.dao.MarkDao;
import com.alexspoonner.dao.ScheduleDao;
import com.alexspoonner.dao.StudentDao;
import com.alexspoonner.model.AcademicGroup;
import com.alexspoonner.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by spoonner on 7/4/17.
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    private StudentDao studentDao;
    private GroupDao groupDao;
    private ScheduleDao scheduleDao;
    private MarkDao markDao;

    @Autowired
    public void setScheduleDao(ScheduleDao scheduleDao) {
        this.scheduleDao = scheduleDao;
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
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }


    @RequestMapping(value = {"/add","/register"}, method = GET)
    public String showAddForm(Model model) {
        List<AcademicGroup> groups = groupDao.findAll();
        model.addAttribute("groups", groups);
        model.addAttribute("student", new Student());
        model.addAttribute("back", "/admin");
        model.addAttribute("title", "Добавить студента");
        return "addStudent";
    }

    @RequestMapping(value = "/edit", method = GET)
    public String showEditForm(@RequestParam(name = "id") String id, Model model) {
        Long studentId = Long.parseLong(id);
        Student studenToEdit = studentDao.findOne(studentId);
        List<AcademicGroup> groups = groupDao.findAll();
        model.addAttribute("groups", groups);
        model.addAttribute("currentGroup", studenToEdit.getAcademicGroup());
        model.addAttribute("student", studenToEdit);
        model.addAttribute("back", "/admin");
        model.addAttribute("title", "Редактировать данные о студенте");
        return "addStudent";
    }

    @RequestMapping(value = "/register", method = POST)
    public String proceedRegistration(@ModelAttribute("student") Student student, HttpServletResponse response) {
        studentDao.save(student);
        Cookie whoCookie = new Cookie("who", "student");
        Cookie idCookie = new Cookie("studentId", student.getStudentId().toString());
        response.addCookie(whoCookie);
        response.addCookie(idCookie);
        return "redirect:/index";
    }

    @RequestMapping(value = {"/add", "/edit"}, method = POST)
    public String proceedAdding(@ModelAttribute("student") Student student) {
        studentDao.save(student);
        return "redirect:/admin";
    }


    @RequestMapping(value = "/delete", method = GET)
    public String proceedDelete(@RequestParam("id") String id) {
        Long studentId = Long.parseLong(id);
        studentDao.delete(studentId);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/personal_info", method = GET)
    public String showStudentPage(HttpServletRequest request, Model model) {
        Long studentId = null;
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("studentId")) {
                studentId = Long.parseLong(cookie.getValue());
            }
        }
        Student student = studentDao.findOne(studentId);
        model.addAttribute("student", student);
        model.addAttribute("schedules", scheduleDao.findAllByAcademicGroup_GroupId(student.getAcademicGroup().getGroupId()));
        model.addAttribute("marks", markDao.findAllByStudent_StudentId(student.getStudentId()));
        return "studentPage";
    }
}
