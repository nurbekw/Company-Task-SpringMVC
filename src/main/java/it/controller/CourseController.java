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

    private final GroupRepository groupRepository;

    private final StudentRepository studentRepository;

    private  final TeacherRepository teacherRepository;
    public CourseController(CompanyRepository companyRepository, CourseRepository courseRepository, GroupRepository groupRepository, StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.companyRepository = companyRepository;
        this.courseRepository = courseRepository;
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }


    @GetMapping("/courseee")
    public String findAll(Model model) {
        model.addAttribute("findAllCourse", courseRepository.findAllCourse());
        model.addAttribute("findAllCompany",companyRepository.findAllCompany());
        return "find-all-course";
    }

    @PostMapping("/form-course")
    public String save(@RequestParam("courseName") String courseName, @RequestParam("duration") String duration,@PathVariable("id") Long id) {
        Company company = companyRepository.findById(id);
        Course course = new Course();
        course.setCourseName(courseName);
        course.setDuration(duration);
        course.setCompany(company);
        courseRepository.saveCourse(course);
        return "redirect:/";
    }

    @GetMapping("/courseForm")
    public String saveCoursePage() {
        return "course-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        courseRepository.deleteById(id);
        return "redirect:/";
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
        companyRepository.updateById(id,course.getCompany());
        return "redirect:/";
    }

    @GetMapping("/clear-course")
    public String clearCourse() {
        courseRepository.clear();
        return "redirect:/";
    }
}
