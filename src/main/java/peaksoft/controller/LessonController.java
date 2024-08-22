package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entiti.Lesson;
import peaksoft.service.LessonService;

@Controller
@RequestMapping("/lessons")
@RequiredArgsConstructor
public class LessonController {
    private final LessonService lessonService;

    @GetMapping("/getAll2")
    public String lessons(Model model) {
        model.addAttribute("lessonGetAll1", lessonService.getAllLessons());
        return "lesson/lessonGetAll";
    }

    @GetMapping("/create1")
    public String createLesson(Model model) {
        model.addAttribute("newLesson1", new Lesson());
        return "lesson/newLesson";
    }

    @PostMapping("/save")
    public String saveLesson(@ModelAttribute("newLesson1") Lesson lesson) {
        lessonService.save(lesson);
        return "redirect:/lessons/getAll2";
    }
    @PostMapping("{id}/delete")
    public String delete(@PathVariable("id")Long id){
        lessonService.delete(id);
        return "redirect:/lessons/getAll2";
    }
}