package it.controller;

import it.model.Company;
import it.repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CompanyController {

    private final CompanyRepository companyRepository;


    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping("/")
    public String findAll(Model model){
        model.addAttribute("findAllCompany",companyRepository.findAllCompany());
        return "find-all";
    }

    @PostMapping("/form-company")
    public String save(@RequestParam("companyName") String companyName, @RequestParam("locatedCounty") String locatedCounty){
        Company company = new Company();
        company.setCompanyName(companyName);
        company.setLocatedCounty(locatedCounty);
        companyRepository.saveCompany(company);
        return "redirect:/";
    }

    @GetMapping("/companyForm")
    public String saveCompanyPage(){
        return "company-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id")Long id){
        companyRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/get/by/{id}")
    public String getById(@PathVariable("id")Long id,Model model){
        Company company = companyRepository.findById(id);
        model.addAttribute("company",company);
        return "find-company";
    }

    @GetMapping("/update/{id}")
    public String updateCompany(@PathVariable("id")Long id,Model model){
        Company company = companyRepository.findById(id);
        model.addAttribute("company", company);
        return "update-form";
    }

    @PostMapping("/company/update/{id}")
    public String realUpdate(@RequestParam("companyName") String companyName,@RequestParam("locatedCounty") String locatedCounty
    ,@PathVariable("id") Long id){
        Company company = new Company();
        company.setCompanyName(companyName);
        company.setLocatedCounty(locatedCounty);
        companyRepository.updateById(id,company);
        return "redirect:/";
    }

    @GetMapping("/clear-company")
    public String clearCompany(){
        companyRepository.clear();
        return "redirect:/";
    }
}
