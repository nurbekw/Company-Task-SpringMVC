package it.controller;

import it.controller.studyformat.StudyFormat;
import it.model.Groups;
import it.model.Student;
import it.repository.CourseRepository;
import it.repository.GroupRepository;
import it.repository.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student/controller/")
public class StudentController {
    private final GroupRepository groupRepository;

    private  final StudentRepository studentRepository;

    private final CourseRepository courseRepository;

    public StudentController(GroupRepository groupRepository, StudentRepository studentRepository, CourseRepository courseRepository) {
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @GetMapping("/menu")
    public String menu(){
        return "redirect:/";
    }

    @GetMapping("/studenttt")
    public String findAll(Model model){
        model.addAttribute("findAllStudent",studentRepository.findAllStudent());
        return "find-all-student";
    }

    @PostMapping("/form-student")
    public String save(@RequestParam("first_name") String first_name, @RequestParam("last_name") String last_name,
                       @RequestParam("email") String email,
                       @RequestParam("studyFormat") StudyFormat studyFormat, @RequestParam("id")Long id){
        Groups groups = groupRepository.findById(id);
        Student student = new Student();
        student.setFirst_name(first_name);
        student.setLast_name(last_name);
        student.setEmail(email);
        student.setStudyFormat(studyFormat);
        student.setGroups(groups);
        studentRepository.saveStudent(student);
        return "redirect:/student/controller/studenttt";
    }

    @GetMapping("/studentForm")
    public String saveStudentPage(Model model){
        model.addAttribute("conGroup",groupRepository.findAllGroup());
        return "student-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id")Long id){
        studentRepository.deleteById(id);
        return "redirect:/student/controller/studenttt";
    }

    @GetMapping("/get/by/{id}")
    public String getById(@PathVariable("id")Long id,Model model){
        Student student = studentRepository.findById(id);
        model.addAttribute("student",student);
        return "find-student";
    }

    @GetMapping("/update/{id}")
    public String updateStudent(@PathVariable("id")Long id, Model model){
        Student student = studentRepository.findById(id);
        model.addAttribute("student",student);
        return "update-form-student";
    }

    @PostMapping("/student/update/{id}")
    public String realUpdate(@RequestParam("first_name") String first_name,@RequestParam("last_name")String last_name
            ,@RequestParam("email")String email,@RequestParam("studyFormat") StudyFormat studyFormat,@PathVariable("id")Long id){
        Student student = new Student();
        student.setFirst_name(first_name);
        student.setLast_name(last_name);
        student.setEmail(email);
        student.setStudyFormat(studyFormat);
        studentRepository.updateById(id,student);
        return "redirect:/student/controller/studenttt";
    }

    @GetMapping("/clear-student")
    public String clearStudent(){
        studentRepository.clear();
        return "redirect:/student/controller/studenttt";
    }
}
