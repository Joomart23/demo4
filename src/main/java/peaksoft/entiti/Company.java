package peaksoft.entiti;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "companies_name")
    @SequenceGenerator(name = "companies_name", sequenceName = "companies_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String country;
    private String address;
    private String phoneNumber;
    @OneToMany(mappedBy = "company")
    private List<Group> groups;
    @ManyToMany
    private List<Instructor> instructors;

}
