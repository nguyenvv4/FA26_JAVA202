package com.example.java202.controller;

import com.example.java202.model.Users;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HomeController {
    ArrayList<Users> listUser = new ArrayList<>();

    public HomeController() {

        listUser.add(new Users(1, "Nguyen Van A"));
        listUser.add(new Users(2, "Nguyen Van B"));
        listUser.add(new Users(3, "Nguyen Van C"));
    }

    @GetMapping("/test")
    public String test() {
        return "REST API OK";
    }

    @GetMapping("/users")
    public Users users() {
        Users users = new Users(1, "Nguyen Van A");
        return users;
    }

    @GetMapping("/list-user")
    public List<Users> listUser() {
        return listUser;
    }

    @PostMapping("/add-user")
    public String addUser(@RequestBody Users users) {
        listUser.add(users);
        return "OK";
    }

    @PutMapping("/update")
    public String updateUser(@RequestBody Users users, @RequestParam("id") Integer id) {
        for (Users user : listUser) {
            if (user.getId().equals(id)) {
                user.setName(users.getName());
            }
        }
        return "OK";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam("id") Integer id) {
        for (Users user : listUser) {
            if (user.getId().equals(id)) {
                listUser.remove(user);
                break;
            }
        }
        return "OK";
    }
}
