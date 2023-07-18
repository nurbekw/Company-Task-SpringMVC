package it.controller;

import it.model.Company;
import it.model.Course;
import it.model.Groups;
import it.repository.CompanyRepository;
import it.repository.CourseRepository;
import it.repository.GroupRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/group/controller/")
public class GroupController {

    private final GroupRepository groupRepository;

    private final CompanyRepository companyRepository;

    private final CourseRepository courseRepository;

    public GroupController(GroupRepository groupRepository, CompanyRepository companyRepository, CourseRepository courseRepository) {
        this.groupRepository = groupRepository;
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

    @GetMapping("/grouppp")
    public String findAll(Model model){
        model.addAttribute("findAllGroup",groupRepository.findAllGroup());
        return "find-all-group";
    }

    @PostMapping("/form-group")
    public String save(@RequestParam("groupName") String groupName,@RequestParam("dateOfStart") String dateOfStart,
                       @RequestParam("dateOfFinish") String dateOfFinish,@RequestParam("id")Long id,
                       @RequestParam("idCourse")Long idCourse){
        Company company = companyRepository.findById(id);
        Course course = courseRepository.findById(idCourse);
        List<Course> courses = new ArrayList<>();
        Groups group = new Groups();
        courses.add(course);
        group.setGroupName(groupName);
        group.setDateOfStart(dateOfStart);
        group.setDateOfFinish(dateOfFinish);
        group.setCompany(company);
        group.setCourse(courses);
        groupRepository.saveGroup(group);
        return "redirect:/group/controller/grouppp";
    }

    @GetMapping("/groupForm")
    public String saveGroupPage(Model model){
        model.addAttribute("conCompanies",companyRepository.findAllCompany());
        model.addAttribute("conCourse",courseRepository.findAllCourse());
        return "group-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id")Long id){
        groupRepository.deleteById(id);
        return "redirect:/group/controller/grouppp";
    }

    @GetMapping("/get/by/{id}")
    public String getById(@PathVariable("id")Long id,Model model){
        Groups group = groupRepository.findById(id);
        model.addAttribute("group",group);
        return "find-group";
    }

    @GetMapping("/update/{id}")
    public String updateGroup(@PathVariable("id")Long id,Model model){
        Groups group = groupRepository.findById(id);
        model.addAttribute("group",group);
        return "update-form-group";
    }

    @PostMapping("/group/update/{id}")
    public String realUpdate(@RequestParam("groupName") String groupName,@RequestParam("dateOfStart")String dateOfStart
    ,@RequestParam("dateOfFinish")String dateOfFinish,@PathVariable("id")Long id){
        Groups group = new Groups();
        group.setGroupName(groupName);
        group.setDateOfStart(dateOfStart);
        group.setDateOfFinish(dateOfFinish);
        groupRepository.updateById(id,group);
        return "redirect:/group/controller/grouppp";
    }

    @GetMapping("/clear-group")
    public String clearGroup(){
        groupRepository.clear();
        return "redirect:/group/controller/grouppp";
    }
}
