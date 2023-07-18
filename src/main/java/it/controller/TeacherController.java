package it.controller;

import it.model.Course;
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

    @GetMapping("/menu")
    public String menu(){
        return "redirect:/";
    }

    @GetMapping("/teacherrr")
    public String findAll(Model model) {
        model.addAttribute("findAllTeacher", teacherRepository.findAllTeacher());
        return "find-all-teacher";
    }

    @PostMapping("/form-teacher")
    public String save(@RequestParam("email") String email, @RequestParam("first_name") String first_name,
                       @RequestParam("last_name")String last_name,@RequestParam("id")Long id) {
        Course course = courseRepository.findById(id);
        Teacher teacher = new Teacher();
        teacher.setEmail(email);
        teacher.setFirst_name(first_name);
        teacher.setLast_name(last_name);
        teacher.setCourses(course);
        teacherRepository.saveTeacher(teacher);
        return "redirect:/teacher/controller/teacherrr";
    }

    @GetMapping("/teacherForm")
    public String saveTeacherPage(Model model) {
        model.addAttribute("conCourses",courseRepository.findAllCourse());
        return "teacher-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        teacherRepository.deleteById(id);
        return "redirect:/teacher/controller/teacherrr";
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
        teacherRepository.updateById(id,teacher);
        return "redirect:/teacher/controller/teacherrr";
    }

    @GetMapping("/clear-teacher")
    public String clearTeacher() {
        teacherRepository.clear();
        return "redirect:/teacher/controller/teacherrr";
    }
}