package com.management.controller;

import com.management.model.Address;
import com.management.model.Role;
import com.management.model.User;
import com.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class MainController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/index")
    public String get(Model model) {
        List<User> users = userService.getAll();
        model.addAttribute("users", users);
        return "index";
    }

    @PostMapping("/user/add")
    public String addUser(@RequestParam(name = "name") String name,
                          @RequestParam(name = "email") String email,
                          @RequestParam(name = "street") String street,
                          @RequestParam(name = "city") String city,
                          @RequestParam(name = "roleName") String roleName) {

        Address address = new Address();
        address.setStreet(street);
        address.setCity(city);

        Role role = new Role();
        role.setName(roleName);
        Set<Role> roles = new HashSet<>();
        roles.add(role);

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setAddress(address);
        user.setRoles(roles);

        userService.add(user);
        return "redirect:/index";
    }



    @GetMapping("/remove/{id}")
    public String removeBook(@PathVariable("id") Integer id) {
        userService.delete(id);
        return "redirect:/index";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "redirect:/index";
    }
}
