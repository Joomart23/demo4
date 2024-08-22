package peaksoft.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entiti.Instructor;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class InstructorRepository  implements peaksoft.repository.InstructorRepository {
    @PersistenceContext
    private final EntityManager em;
    @Override
    public List<Instructor> geAllInstructors() {
        return  em.createQuery("select i from Instructor i", Instructor.class).getResultList();
    }

    @Override
    public void updateInstructor(Long instructor_id, Instructor instructor) {
        em.find(Instructor.class, instructor_id);
        em.merge(instructor);

    }

    @Override
    public void deleteInstructor(Long instructor_id) {
      Instructor instructor =  (em.find(Instructor.class, instructor_id));
        em.remove(instructor);

    }

    @Override
    public void createInstructor(Instructor instructor) {
        em.persist(instructor);

    }
}
