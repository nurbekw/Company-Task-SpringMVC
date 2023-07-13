package it.controller;

import it.model.Student;
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

    public StudentController(GroupRepository groupRepository, StudentRepository studentRepository) {
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
    }

    @GetMapping("/studenttt")
    public String findAll(Model model){
        model.addAttribute("/findAllStudent",studentRepository.findAllStudent());
        return "find-all-student";
    }

    @PostMapping("/form-student")
    public String save(@RequestParam("first_name") String first_name, @RequestParam("last_name") String last_name,
                       @RequestParam("email") String email,@RequestParam("studyFormat")String studyFormat){
        Student student = new Student();
        student.setFirst_name(first_name);
        student.setLast_name(last_name);
        student.setEmail(email);
        student.setStudyFormat(studyFormat);
        groupRepository.saveGroup(student.getGroups());
        studentRepository.saveStudent(student);
        return "redirect:/";
    }

    @GetMapping("/studentForm")
    public String saveStudentPage(){
        return "student-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id")Long id){
        studentRepository.deleteById(id);
        return "redirect:/";
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
            ,@RequestParam("email")String email,@RequestParam("studyFormat") String studyFormat,@PathVariable("id")Long id){
        Student student = new Student();
        student.setFirst_name(first_name);
        student.setLast_name(last_name);
        student.setEmail(email);
        student.setStudyFormat(studyFormat);
        groupRepository.updateById(id,student.getGroups());
        studentRepository.updateById(id,student);
        return "redirect:/";
    }

    @GetMapping("/clear-student")
    public String clearStudent(){
        studentRepository.clear();
        return "redirect:/";
    }
}
