package com.zaitsava.spring_project_notes.controller;

import com.zaitsava.spring_project_notes.entity.Message;
import com.zaitsava.spring_project_notes.entity.User;
import com.zaitsava.spring_project_notes.repository.MassageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String main(Map<String, Object> model) {
        Iterable<Message> massages = massageRepository.findAll();

        model.put("messages", massages);
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

    @PostMapping("/filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Message> massages;

        if (filter != null && !filter.isEmpty()) {
            massages = massageRepository.findByTag(filter);
        } else {
            massages = massageRepository.findAll();
        }
        model.put("messages", massages);
        return "index";
    }
}
