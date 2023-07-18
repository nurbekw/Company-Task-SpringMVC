package it.controller;

import it.model.Company;
import it.model.Course;
import it.repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/course/controller/")
public class CourseController {

    private final CompanyRepository companyRepository;

    private final CourseRepository courseRepository;
    public CourseController(CompanyRepository companyRepository, CourseRepository courseRepository) {
        this.companyRepository = companyRepository;
        this.courseRepository = courseRepository;
    }

    @GetMapping("/menu")
    public String menu(){
        return "redirect:/";
    }

    @GetMapping("/backToCompany")
    public String backToCompany(){
        return "redirect:/";
    }

    @GetMapping("/courseee")
    public String findAll(Model model) {
        model.addAttribute("findAllCourse", courseRepository.findAllCourse());
        return "find-all-course";
    }

    @PostMapping("/form-course")
    public String save(@RequestParam("courseName") String courseName, @RequestParam("duration") String duration,@RequestParam("id") Long id) {
        Company company = companyRepository.findById(id);
        Course course = new Course();
        course.setCourseName(courseName);
        course.setDuration(duration);
        course.setCompany(company);
        courseRepository.saveCourse(course);
        return "redirect:/course/controller/courseee";
    }

    @GetMapping("/courseForm")
    public String saveCoursePage(Model model) {
        model.addAttribute("conCompany",companyRepository.findAllCompany());
        return "course-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        courseRepository.deleteById(id);
        return "redirect:/course/controller/courseee";
    }

    @GetMapping("/get/by/{id}")
    public String getById(@PathVariable("id") Long id, Model model) {
        Course course = courseRepository.findById(id);
        model.addAttribute("course", course);
        return "find-course";
    }

    @GetMapping("/update/{id}")
    public String updateCourse(@PathVariable("id") Long id, Model model) {
        Course course = courseRepository.findById(id);
        model.addAttribute("course", course);
        return "update-form-course";
    }

    @PostMapping("/course/update/{id}")
    public String realUpdate(@RequestParam("courseName") String courseName, @RequestParam("duration") String duration,
                             @PathVariable("id") Long id) {
        Course course = new Course();
        course.setCourseName(courseName);
        course.setDuration(duration);
        courseRepository.updateById(id, course);
        return "redirect:/course/controller/courseee";
    }

    @GetMapping("/clear-course")
    public String clearCourse() {
        courseRepository.clear();
        return "redirect:/course/controller/courseee";
    }
}
