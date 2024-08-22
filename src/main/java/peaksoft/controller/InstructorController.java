package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entiti.Instructor;
import peaksoft.service.InstructorService;

@Controller
@RequestMapping("/instructor")
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService instructorService;
    @GetMapping("insGetAll")
    public String getAllCompanies(Model model) {
        model.addAttribute("getAllInstructor", instructorService.geAllInstructors());
        return "Instructor/getAllInstructor";
    }

    @GetMapping("create")
    public String createCompany(Model model) {
        model.addAttribute("newInstructor", new Instructor());
        return "Instructor/newInstructor";

    }

    @PostMapping("/save")
    public String saveCompany(@ModelAttribute("newInstructor") Instructor group) {
        instructorService.createInstructor(group);
        System.out.println("saved"+group.getFistName());
        return "redirect:/instructor/insGetAll";

    }

    @DeleteMapping("/{id}")
    public String deleteCompany(@PathVariable("id") Long id) {
        instructorService.deleteInstructor(id);
        return "redirect:/companies";
    }




//    // Жаңыртууну ишке ашыруу үчүн PUT метод
//    @PostMapping("/update/{id}")
//    public String updateGroup(@PathVariable("id") Long id, @ModelAttribute Group group) {
//        Group updatedGroup = groupService.newGroup(id, group);
//        if (updatedGroup == null) {
//            // Эгерде жаңыртуу операциясы ишке ашпаса, ката бетине багыттоо
//            return "error/500"; // Же башка ката бетине
//        }
//        return "redirect:/group/details/" + id;
//    }
//
//    @GetMapping("/update/{id}")
//    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
//        Group group = groupService.getGroup(id);
//        if (group == null) {
//            // Эгерде объект табылбаса, ката бетине багыттоо
//            return "/update"; // Же башка ката бетине
//        }
//        model.addAttribute("update1", group);
//        return "update"; // Бул 'update.html' деген HTML бети
//    }
//}


}
