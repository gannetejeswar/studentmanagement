package com.tejeswar.student_management.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.tejeswar.student_management.entity.Student;
import com.tejeswar.student_management.service.StudentService;

@Controller
public class StudentController {

    @Autowired
    private StudentService service;
    @GetMapping("/login")
    public String login(){

    return "login";

}

@GetMapping("/dashboard")
public String dashboard(Model model){

    model.addAttribute("students",
            service.getAllStudents());

    return "dashboard";

}
@GetMapping("/edit/{id}")

public String editStudent(
@PathVariable Long id,
Model model){

Student student =
service.getStudentById(id);

model.addAttribute(
"student",
student);

return "edit-student";

}

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("students", service.getAllStudents());
        model.addAttribute("student", new Student());
        return "dashboard";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute Student student) {
        service.saveStudent(student);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
        return "redirect:/";
    }
    
@GetMapping("/students")
public String viewStudents(Model model) {

    model.addAttribute("students", service.getAllStudents());

    return "students";
}

@GetMapping("/add")
public String showAddStudentForm(Model model) {

    model.addAttribute("student", new Student());

    return "add-student";
}
}