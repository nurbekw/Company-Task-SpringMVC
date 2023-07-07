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
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    //Date of finish-дата окончания
    private String dateOfFinish;

    //Date of start-дата старта
    private String dateOfStart;

    private String groupName;

    @ManyToOne(cascade = CascadeType.ALL)
    private Company company;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "course_groups"
            , joinColumns = @JoinColumn(name = "group_id")
            , inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> course;

    @OneToMany(mappedBy = "groups",cascade = CascadeType.ALL)
    private List<Student> students;
}
