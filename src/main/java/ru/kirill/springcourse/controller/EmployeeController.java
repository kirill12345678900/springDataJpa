package ru.kirill.springcourse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kirill.springcourse.Service.AllService;
import ru.kirill.springcourse.model.Employee;

import java.util.List;

@Controller
public class EmployeeController {

    private final AllService allService;

    @Autowired
    public EmployeeController(AllService allService) {
        this.allService = allService;
    }

    @GetMapping("/users")
    public String findAll(Model model){
        List<Employee> users = allService.findAll();
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("/user-create")
    public String createUserForm(Employee employee){
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(Employee employee){
        allService.saveUser(employee);
        return "redirect:/users";
    }
}
