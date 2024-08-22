package peaksoft.controller;//package peaksoft.controller;
//
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import peaksoft.entiti.Group;
import peaksoft.service.GroupService;
import peaksoft.service.InstructorService;


@Controller
@RequestMapping("/companies")
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;
    private final InstructorService instructorService;

    @GetMapping
    public String getAllCompanies(Model model) {
        model.addAttribute("getAll1", groupService.getAllCompanies());
        model.addAttribute("getAllIns", instructorService.geAllInstructors());
        return "getAll";
    }

    @GetMapping("create")
    public String createCompany(Model model) {
        model.addAttribute("newGroup", new Group());
        return "newGroup";

    }

    @PostMapping("save")
    public String saveCompany(@ModelAttribute("newGroup") Group group) {
        groupService.save(group);
        System.out.println("group saved");
        return "redirect:/companies";

    }

    @DeleteMapping("/{id}")
    public String deleteCompany(@PathVariable("id") Long id) {
        groupService.delete(id);
        return "redirect:/companies";
    }


    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Group group = groupService.getGroup(id);
        model.addAttribute("company", group);
        return "updateCompanyForm"; // Жаңыртуучу форманын аты
    }

    @PostMapping("/update")
    public String updateGroup(Group group) {
        groupService.save(group);
        return "redirect:/companies";
    }
}



