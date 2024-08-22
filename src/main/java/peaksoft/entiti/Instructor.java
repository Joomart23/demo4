package peaksoft.entiti;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "instructors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "instructors_name")
    @SequenceGenerator(name = "instructors_name", sequenceName = "instructors_seq", allocationSize = 1)
    private Long id;
    private String fistName;
    private String lastName;
    private String phoneNumber;
    // АДИСТИК
    private String specialization;
   @ManyToMany(mappedBy = "instructors")
   private List<Company> courses;
   @OneToMany(mappedBy = "instructor")
    private List<Course> courseList;


}
