package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entiti.Company;
import peaksoft.service.CompanyService;

@Controller
@RequestMapping("/companiess")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;
    @GetMapping
    public String getAllCompanies(Model model) {
        model.addAttribute("getAllCompany", companyService.getAllCompanies());
        return "getAllCompany";
    }

    @GetMapping("create")
    public String createCompany(Model model) {
        model.addAttribute("newCompany", new Company());
        return "company/newCompany";

    }

    @PostMapping("save")
    public String saveCompany(@ModelAttribute("newCompany") Company group) {
        companyService.save(group);
        System.out.println("group saved");
        return "redirect:/companiess";

    }

    @DeleteMapping("/{id}")
    public String deleteCompany(@PathVariable("id") Long id) {
        companyService.delete(id);
        return "redirect:/companies";
    }


//    @GetMapping("/update/{id}")
//    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
//        Group group = companyService(id);
//        model.addAttribute("company", group);
//        return "updateCompanyForm"; // Жаңыртуучу форманын аты
//    }
//
//    @PostMapping("/update")
//    public String updateGroup(Company group) {
//        companyService.save(group);
//        return "redirect:/companies";
//    }
}
