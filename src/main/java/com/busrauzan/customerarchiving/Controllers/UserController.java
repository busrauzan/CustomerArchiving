package com.busrauzan.customerarchiving.Controllers;

import com.busrauzan.customerarchiving.DataAccess.UserRepository;
import com.busrauzan.customerarchiving.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/users")
    public List<User> getAllFolders() {
        return userRepository.findAll();
    }
}
