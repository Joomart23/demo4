package peaksoft.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entiti.Lesson;
import peaksoft.repository.LessonRepository;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class LessonRepositoryImpl implements LessonRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Lesson> getAllLessons() {
        return em.createQuery("SELECT l FROM Lesson l", Lesson.class).getResultList();
    }

    @Override
    public void save(Lesson lesson) {

        em.persist(lesson);
    }

    @Override
    public void delete(Long id) {
        Lesson lesson = em.find(Lesson.class, id);
       em.remove(lesson);
    }

    @Override
    public Lesson update(Long id, Lesson lesson) {
        Lesson existingLesson = em.find(Lesson.class, id);
        if (existingLesson != null) {
            existingLesson.setLessonName(lesson.getLessonName()); // Жаңыртуу үчүн өзгөртүү
            return em.merge(existingLesson);
        }
        return null;
    }

    @Override
    public Lesson getById(Long id) {
        return em.find(Lesson.class, id);
    }
}

