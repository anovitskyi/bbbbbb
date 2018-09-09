package com.ano.instarandom.controllers;

import com.ano.instarandom.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

@Controller
public class MainController {

    @Autowired
    private UserService users;

    private Random random = new Random();

    @RequestMapping("/")
    public String getMainPage() {
        return "index";
    }

    @RequestMapping("/random")
    public String findWinner() {
        if (users.list().isEmpty()) {
            return "no-winner";
        }

        int rand = random.nextInt(users.list().size());
        String url = users.list().get(rand);
        if (!url.startsWith("http")) {
            url = "http://" + url;
        }
        return "redirect:" + url;
    }

}
