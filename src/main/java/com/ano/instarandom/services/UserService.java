package com.ano.instarandom.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<String> users = new ArrayList<>();

    public List<String> list() {
        return users;
    }

}
