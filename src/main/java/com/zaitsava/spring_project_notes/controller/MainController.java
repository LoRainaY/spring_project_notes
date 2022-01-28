package com.zaitsava.spring_project_notes.controller;

import com.zaitsava.spring_project_notes.entity.Message;
import com.zaitsava.spring_project_notes.entity.User;
import com.zaitsava.spring_project_notes.repository.MassageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private MassageRepository massageRepository;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/index")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Message> massages = massageRepository.findAll();
        if (filter != null && !filter.isEmpty()) {
            massages = massageRepository.findByTag(filter);
        } else {
            massages = massageRepository.findAll();
        }
        model.addAttribute("messages", massages);
        model.addAttribute("filter", filter);
        return "index";
    }

    @PostMapping("/index")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String description,
            @RequestParam String tag, Map<String, Object> model) {
        Message message = new Message(description, tag, user);
        massageRepository.save(message);
        Iterable<Message> massages = massageRepository.findAll();

        model.put("messages", massages);
        return "index";

    }
    @GetMapping("/index/{user}")
    public String userDelete(@PathVariable User user, Model model) {
        Iterable<Message> userMessage = massageRepository.findByAuthor(user);
        model.addAttribute("messages", userMessage);

        return "index";
    }




}
