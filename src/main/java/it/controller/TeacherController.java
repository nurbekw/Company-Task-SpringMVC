package it.controller;

import it.model.Teacher;
import it.repository.CourseRepository;
import it.repository.TeacherRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/teacher/controller/")
public class TeacherController {

    private final TeacherRepository teacherRepository;

    private final CourseRepository courseRepository;

    public TeacherController(TeacherRepository teacherRepository, CourseRepository courseRepository) {
        this.teacherRepository = teacherRepository;
        this.courseRepository = courseRepository;
    }

    @GetMapping("/teacherrr")
    public String findAll(Model model) {
        model.addAttribute("findAllTeacher", teacherRepository.findAllTeacher());
        return "find-all-teacher";
    }

    @PostMapping("/form-teacher")
    public String save(@RequestParam("email") String email, @RequestParam("first_name") String first_name,
                       @RequestParam("last_name")String last_name) {
        Teacher teacher = new Teacher();
        teacher.setEmail(email);
        teacher.setFirst_name(first_name);
        teacher.setLast_name(last_name);
        courseRepository.saveCourse(teacher.getCourses());
        teacherRepository.saveTeacher(teacher);
        return "redirect:/";
    }

    @GetMapping("/teacherForm")
    public String saveTeacherPage() {
        return "teacher-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        teacherRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/get/by/{id}")
    public String getById(@PathVariable("id") Long id, Model model) {
        Teacher teacher = teacherRepository.findById(id);
        model.addAttribute("teacher", teacher);
        return "find-teacher";
    }

    @GetMapping("/update/{id}")
    public String updateTeacher(@PathVariable("id") Long id, Model model) {
        Teacher teacher = teacherRepository.findById(id);
        model.addAttribute("teacher", teacher);
        return "update-form-teacher";
    }

    @PostMapping("/teacher/update/{id}")
    public String realUpdate(@RequestParam("email") String email, @RequestParam("first_name") String first_name,
                             @RequestParam("last_name")String last_name,@PathVariable("id") Long id) {
        Teacher teacher = new Teacher();
        teacher.setEmail(email);
        teacher.setFirst_name(first_name);
        teacher.setLast_name(last_name);
        courseRepository.updateById(id, teacher.getCourses());
        teacherRepository.updateById(id,teacher);
        return "redirect:/";
    }

    @GetMapping("/clear-teacher")
    public String clearTeacher() {
        teacherRepository.clear();
        return "redirect:/";
    }
}