package peaksoft.entiti;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "groups")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "groups_name")
    @SequenceGenerator(name = "groups_name", sequenceName = "groups_seq", allocationSize = 1)
    private Long id;
    private String groupName;
   private String imageLink;
    private String description;
    @ManyToOne
   private Company company;
   @OneToMany(mappedBy = "group")
   private List<Student> students;
   @OneToMany(mappedBy = "group")
   private List<Course> course;

}