package com.alexspoonner.contollers.main;

import com.alexspoonner.dao.StudentDao;
import com.alexspoonner.dao.TeacherDao;
import com.alexspoonner.model.Student;
import com.alexspoonner.model.Teacher;
import com.alexspoonner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by spoonner on 7/6/17.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    private UserService userService;
    private StudentDao studentDao;
    private TeacherDao teacherDao;

    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "", method = POST)
    public String index(@RequestParam(name = "email") String email,
                        @RequestParam(name = "password") String password,
                        @RequestParam(name = "login") String login, HttpServletResponse response) {
        if (login.toLowerCase().contains("register")) {
            return "addStudent";
        } else {
            String role = userService.getRole(email, password);
            if (role.equals("student")) {
                Student student = studentDao.findStudentByEmailAndPassword(email,password);
                response.addCookie(new Cookie("studentId", student.getStudentId().toString()));
            } else if (role.equals("teacher")) {
                Teacher teacher =teacherDao.findTeacherByEmailAndPassword(email, password);
                response.addCookie(new Cookie("teacherId", teacher.getTeacherId().toString()));
            }
            Cookie cookie = new Cookie("who", role);
            response.addCookie(cookie);
            return "redirect:/";
        }
    }
}
