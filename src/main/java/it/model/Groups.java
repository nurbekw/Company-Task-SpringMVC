package it.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Date of finish-дата окончания
    private String dateOfFinish;

    //Date of start-дата старта
    private String dateOfStart;

    private String groupName;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "groups_courses"
            , joinColumns = @JoinColumn(name = "group_id")
            , inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> course;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "groups")
    private List<Student> students;
}
