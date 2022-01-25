package com.zaitsava.spring_project_notes.controller;

import com.zaitsava.spring_project_notes.entity.Role;
import com.zaitsava.spring_project_notes.entity.User;
import com.zaitsava.spring_project_notes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }
    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        User userByUsername=userRepository.findByUsername(user.getUsername());
        if(userByUsername!=null){
            model.put("message","Пользователь с таким именем уже существует");
            return "registration";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.ROLE_USER));
        userRepository.save(user);

        return "redirect:/login";
    }
}
