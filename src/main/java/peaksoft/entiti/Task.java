package peaksoft.entiti;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tasks_name")
    @SequenceGenerator(name = "tasks_name", sequenceName = "tasks_seq", allocationSize = 1)
    private Long id;
    private String taskName;
    private String taskText;
    private String deadLine;
    @ManyToOne
    private Lesson lesson;

}
