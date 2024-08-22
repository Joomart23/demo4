package peaksoft.service.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entiti.Lesson;
import peaksoft.repository.LessonRepository;
import peaksoft.service.LessonService;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;
    @Override
    public List<Lesson> getAllLessons() {
        return lessonRepository.getAllLessons();
    }

    @Override
    public void save(Lesson lesson) {
        lessonRepository.save(lesson);

    }

    @Override
    public void delete(Long id) {
        lessonRepository.delete(id);

    }

    @Override
    public Lesson update(Long id , Lesson lesson) {
        return lessonRepository.update(id,lesson);
    }

    @Override
    public Lesson getById(Long id) {
        return lessonRepository.getById(id);

    }
}
