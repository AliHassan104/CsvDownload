package com.example.DownloadCsv.service;

import com.example.DownloadCsv.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    public List<User> listUsers() {
        List<User> users = new ArrayList<>();

        users.add(new User(1, "Jack Lee", "jack@example.com", "Germany", 35));
        users.add(new User(2, "Jovan Srovoki", "jovan@srovoki.me", "Russia", 21));
        users.add(new User(3, "Atta", "atta@gmail.com", "Pakistan", 29));

        return users;
    }

}
