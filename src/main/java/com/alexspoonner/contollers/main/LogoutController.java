package com.alexspoonner.contollers.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by spoonner on 7/6/17.
 */
@Controller
@RequestMapping("/logout")
public class LogoutController {

    @RequestMapping(value = "", method = GET)
    public String logoutAction(HttpServletRequest request, HttpServletResponse response) {

        /**
         * Clear all set cookies
         */
        Cookie cookie = new Cookie("who", null);
        cookie.setHttpOnly(true);
        cookie.setMaxAge(0);

        Cookie studentIdCookie = new Cookie("studentId", null);
        studentIdCookie.setHttpOnly(true);
        studentIdCookie.setMaxAge(0);

        Cookie teacherIdCookie = new Cookie("teacherId", null);
        teacherIdCookie.setHttpOnly(true);
        teacherIdCookie.setMaxAge(0);

        response.addCookie(studentIdCookie);
        response.addCookie(teacherIdCookie);
        response.addCookie(cookie);
        return "redirect:/index";
    }
}
