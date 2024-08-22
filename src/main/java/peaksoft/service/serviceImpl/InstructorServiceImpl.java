package peaksoft.service.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entiti.Instructor;
import peaksoft.repository.InstructorRepository;
import peaksoft.service.InstructorService;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;
    @Override
    public List<Instructor> geAllInstructors() {
        instructorRepository.geAllInstructors();

        return null;
    }

    @Override
    public void updateInstructor(Long instructor_id, Instructor instructor) {
        instructorRepository.updateInstructor(instructor_id, instructor);

    }

    @Override
    public void deleteInstructor(Long instructor_id) {
        instructorRepository.deleteInstructor(instructor_id);

    }

    @Override
    public void createInstructor( Instructor instructor) {
        instructorRepository.createInstructor(instructor);

    }
}