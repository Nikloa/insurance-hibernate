package ru.vironit.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.vironit.app.entities.Client;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(ModelMap model) {

        return "profile";
    }
}
