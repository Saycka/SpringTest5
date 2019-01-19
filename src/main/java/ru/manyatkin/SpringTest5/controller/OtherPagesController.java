package ru.manyatkin.SpringTest5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OtherPagesController {

    @GetMapping("/contacts")
    public String contacts (Model model) {
        model.addAttribute("page_title", "Contacts");
        return "pages/other_pages/contacts";
    }
}
