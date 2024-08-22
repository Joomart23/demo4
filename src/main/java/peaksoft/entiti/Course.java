package peaksoft.entiti;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "courses_name")
    @SequenceGenerator(name = "courses_name", sequenceName = "courses_seq", allocationSize = 1)
    private Long id;
    private String courseName;
    private LocalDate dateOfStart;
    private String description;
    @ManyToOne
    private Instructor instructor;
    @ManyToOne
    private Group group;
    @OneToMany(mappedBy = "course")
    private List<Lesson> lessons;

}
