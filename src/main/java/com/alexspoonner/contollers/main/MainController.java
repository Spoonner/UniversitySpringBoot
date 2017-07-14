package com.alexspoonner.contollers.main;

import com.alexspoonner.dao.StudentDao;
import com.alexspoonner.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Main page controller
 */

@Controller
public class MainController {

    private StudentDao studentDao;

    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public StudentDao getStudentDao() {
        return this.studentDao;
    }

    @RequestMapping(value = {"/", "/index"}, method = GET)
    public String index(Model model, @CookieValue(name = "who", required = false, defaultValue = "norole") String role) {
        List<Student> topStudents = studentDao.findTop10ByOrderByAverageMarkDesc();
        model.addAttribute("who", role);
        model.addAttribute("title", "Главная страница");
        model.addAttribute("topStudents", topStudents);
        return "index";
    }

}
