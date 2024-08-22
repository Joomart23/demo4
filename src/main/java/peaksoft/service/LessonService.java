package peaksoft.service;

import peaksoft.entiti.Lesson;

import java.util.List;

public interface LessonService {
    List<Lesson> getAllLessons(); // Тартылган бардык сабактар
    void save(Lesson lesson); // Сабакты сактоо
    void delete(Long id); // Сабакты ID аркылуу өчүрүү
    Lesson update(Long id, Lesson lesson); // Сабакты ID аркылуу жаңыртуу
    Lesson getById(Long id); // Сабакты ID аркылуу алуу
}

