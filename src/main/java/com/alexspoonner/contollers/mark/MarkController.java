package com.alexspoonner.contollers.mark;

import com.alexspoonner.dao.*;
import com.alexspoonner.model.Mark;
import com.alexspoonner.model.Student;
import com.alexspoonner.model.Subject;
import com.alexspoonner.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by spoonner on 7/4/17.
 */
@Controller
@RequestMapping("/mark")
public class MarkController {

    private MarkDao markDao;
    private StudentDao studentDao;
    private SubjectDao subjectDao;
    private TeacherDao teacherDao;
    private ScheduleDao scheduleDao;

    @Autowired
    public void setScheduleDao(ScheduleDao scheduleDao) {
        this.scheduleDao = scheduleDao;
    }

    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Autowired
    public void setSubjectDao(SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }

    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Autowired
    public void setMarkDao(MarkDao markDao) {
        this.markDao = markDao;
    }

    @RequestMapping(value = "/add", method = GET)
    public String showAddForm(Model model) {
        model.addAttribute("mark", new Mark());
        model.addAttribute("title", "Добавить оценку");
        model.addAttribute("back", "/admin");
        //TODO: add all subj, teachers, students to select option
        Map<Student, List<Teacher>> studentTeacherMap = new HashMap<>();
        List<Student> studentList = studentDao.findAll();
        for (Student student : studentList) {
            List<Teacher> teachers = scheduleDao.findAllTeachersByGroupId(student.getAcademicGroup().getGroupId());
            studentTeacherMap.put(student, teachers);
        }
        Map<Teacher, List<Subject>> teacherSubjectMap = new HashMap<>();
        List<Teacher> teacherList = teacherDao.findAll();
        for (Teacher teacher : teacherList) {
            List<Subject> subjects = scheduleDao.findAllSubjectsByTeacherId(teacher.getTeacherId());
            teacherSubjectMap.put(teacher,subjects);
        }
        model.addAttribute("studentTeacherMap", studentTeacherMap);
        model.addAttribute("teacherSubjectMap", teacherSubjectMap);
        model.addAttribute("students", studentList);
        return "addMark";
    }

    @RequestMapping(value = {"/add", "/edit"}, method = POST)
    public String proceedAddingMark(@ModelAttribute("mark") Mark newMark) {
        markDao.save(newMark);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/edit", method = GET)
    public String showEditForm(Model model, @RequestParam("id") String id) {
        Long markId = Long.parseLong(id);
        Mark markToEdit = markDao.findOne(markId);
        model.addAttribute("mark", markToEdit);
        model.addAttribute("title","Изменить оценку");
        model.addAttribute("back", "/admin");
        return "addMark";
    }

    @RequestMapping(value = "/delete", method = GET)
    public String proceedDeletingMark(@RequestParam("id") String id) {
        markDao.delete(Long.parseLong(id));
        return "redirect:/admin";
    }

}
