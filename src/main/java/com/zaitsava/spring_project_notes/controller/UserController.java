package com.zaitsava.spring_project_notes.controller;

import com.zaitsava.spring_project_notes.entity.Message;
import com.zaitsava.spring_project_notes.entity.Role;
import com.zaitsava.spring_project_notes.entity.User;
import com.zaitsava.spring_project_notes.repository.MassageRepository;
import com.zaitsava.spring_project_notes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MassageRepository massageRepository;

    @GetMapping
    public String userList(Model model) {
        model.addAttribute("users", userRepository.findAll());

        return "userList";
    }

    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());

        return "userEdit";
    }

    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user
    ) {
        user.setUsername(username);

        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();

        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }

        userRepository.save(user);

        return "redirect:/user";
    }
    @GetMapping("/remove/{user}")
    public String userDelete(@PathVariable User user, Model model) {
        Iterable<Message> deleteMessage = massageRepository.findByAuthor(user);
        massageRepository.deleteAll(deleteMessage);
        user.getRoles().clear();
        userRepository.delete(user);
        return "redirect:/user";
    }
}
