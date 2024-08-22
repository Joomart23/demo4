package peaksoft.entiti;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "lessons")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lessons_name")
    @SequenceGenerator(name = "lessons_name", sequenceName = "lessons_seq", allocationSize = 1)
    private Long id;
    private String lessonName;
    private String imageLink;
    @ManyToOne
    private Course course;
    @OneToMany(mappedBy = "lesson")
    private List<Task> tasks;

}
