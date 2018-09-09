package com.ano.instarandom.controllers;

import com.ano.instarandom.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/instarandom")
public class UserController {

    @Autowired
    private UserService users;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addNewUserView(Model model) {
        String usersStr = users
                .list()
                .stream()
                .reduce((a, b) -> a + "\n" + b)
                .orElse("");
        model.addAttribute("u", usersStr);
        return "add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addNewUserLogic(@RequestParam String newUsers, Model model) {
        if (newUsers.isEmpty()) {
            return "no-winner";
        }

        users
                .list()
                .clear();

        users
                .list()
                .addAll(
                        Arrays.asList(newUsers.split("\n"))
                        .stream()
                        .filter(it -> !it.trim().isEmpty())
                        .collect(Collectors.toList())
                );

        String usersStr = users
                .list()
                .stream()
                .reduce((a, b) -> a + "\n" + b)
                .orElse("");
        model.addAttribute("u", usersStr);
        return "add";
    }

}
