package com.alexspoonner.contollers.group;

import com.alexspoonner.dao.GroupDao;
import com.alexspoonner.model.AcademicGroup;
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
@RequestMapping("/group")
public class GroupController {

    private GroupDao groupDao;

    @Autowired
    public void setGroupDao(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @RequestMapping(value = "/add", method = GET)
    public String showAddForm(Model model) {
        model.addAttribute("title", "Добавить новую группу");
        model.addAttribute("group", new AcademicGroup());
        model.addAttribute("back", "/admin");
        return "addGroup";
    }

    @RequestMapping(value = {"/add", "/edit"}, method = POST)
    public String proceedAddingGroup(@ModelAttribute(name = "group") AcademicGroup group) {
        groupDao.save(group);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/edit", method = GET)
    public String showEditForm(@RequestParam(name = "id") String id, Model model) {
        AcademicGroup groupToEdit = groupDao.findOne(Long.parseLong(id));
        model.addAttribute("group", groupToEdit);
        model.addAttribute("title", "Изменить информацию о группе");
        model.addAttribute("back", "/admin");
        return "addGroup";
    }

    @RequestMapping(value = "/delete", method = GET)
    public String proceedDeletingGroup(@RequestParam("id")String id) {
        groupDao.delete(Long.parseLong(id));
        return "redirect:/admin";
    }
}

