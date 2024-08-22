package peaksoft.repository;

import peaksoft.entiti.Instructor;

import java.util.List;

public interface InstructorRepository {
    List<Instructor>geAllInstructors();
    void updateInstructor(Long instructor_id , Instructor instructor);
    void deleteInstructor(Long instructor_id);
    void createInstructor( Instructor instructor);

}
