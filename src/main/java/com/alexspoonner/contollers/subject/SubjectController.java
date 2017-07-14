package com.alexspoonner.contollers.subject;

import com.alexspoonner.dao.SubjectDao;
import com.alexspoonner.model.Subject;
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
@RequestMapping("/subject")
public class SubjectController {
    private SubjectDao subjectDao;

    @Autowired
    public void setSubjectDao(SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }

    @RequestMapping(value = "/add", method = GET)
    public String showAddForm(Model model) {
        model.addAttribute("subject", new Subject());
        model.addAttribute("title", "Добавить предмет");
        model.addAttribute("back", "/admin");
        return "addSubject";
    }

    @RequestMapping(value = {"/add", "/edit"}, method = POST)
    public String proceedAddingSubject(@ModelAttribute(name = "subject") Subject newSubject) {
        subjectDao.save(newSubject);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/edit", method = GET)
    public String showEditForm(@RequestParam("id") String id, Model model) {
        model.addAttribute("subject", subjectDao.findOne(Long.parseLong(id)));
        model.addAttribute("title", "Изменить предмет");
        model.addAttribute("back", "/admin");
        return "addSubject";
    }

    @RequestMapping(value = "/delete", method = GET)
    public String proceedDeletingSubject(@RequestParam("id") String id) {
        subjectDao.delete(Long.parseLong(id));
        return "redirect:/admin";
    }
}
