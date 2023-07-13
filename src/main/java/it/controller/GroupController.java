package it.controller;

import it.model.Group;
import it.repository.CompanyRepository;
import it.repository.GroupRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/group/controller/")
public class GroupController {

    private final GroupRepository groupRepository;

    private final CompanyRepository companyRepository;

    public GroupController(GroupRepository groupRepository, CompanyRepository companyRepository) {
        this.groupRepository = groupRepository;
        this.companyRepository = companyRepository;
    }

    @GetMapping("/grouppp")
    public String findAll(Model model){
        model.addAttribute("/findAllGroup",groupRepository.findAllGroup());
        return "find-all-group";
    }

    @PostMapping("/form-group")
    public String save(@RequestParam("groupName") String groupName,@RequestParam("dateOfStart") String dateOfStart,
                       @RequestParam("dateOfFinish") String dateOfFinish){
        Group group = new Group();
        group.setGroupName(groupName);
        group.setDateOfStart(dateOfStart);
        group.setDateOfFinish(dateOfFinish);
        groupRepository.saveGroup(group);
        companyRepository.saveCompany(group.getCompany());
        return "redirect:/";
    }

    @GetMapping("/groupForm")
    public String saveGroupPage(){
        return "group-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id")Long id){
        groupRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/get/by/{id}")
    public String getById(@PathVariable("id")Long id,Model model){
        Group group = groupRepository.findById(id);
        model.addAttribute("group",group);
        return "find-group";
    }

    @GetMapping("/update/{id}")
    public String updateGroup(@PathVariable("id")Long id,Model model){
        Group group = groupRepository.findById(id);
        model.addAttribute("group",group);
        return "update-form-group";
    }

    @PostMapping("/group/update/{id}")
    public String realUpdate(@RequestParam("groupName") String groupName,@RequestParam("dateOfStart")String dateOfStart
    ,@RequestParam("dateOfFinish")String dateOfFinish,@PathVariable("id")Long id){
        Group group = new Group();
        group.setGroupName(groupName);
        group.setDateOfStart(dateOfStart);
        group.setDateOfFinish(dateOfFinish);
        groupRepository.updateById(id,group);
        companyRepository.updateById(id,group.getCompany());
        return "redirect:/";
    }

    @GetMapping("/clear-group")
    public String clearGroup(){
        groupRepository.clear();
        return "redirect:/";
    }
}
