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
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String courseName;

    //Duration-Продолжительность
    private String duration;

    @ManyToOne(cascade = CascadeType.ALL)
    private Company company;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "groups_courses"
            , joinColumns = @JoinColumn(name = "course_id")
            , inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private List<Groups> group;

    @OneToOne(mappedBy = "courses",cascade = CascadeType.ALL)
    private Teacher teacher;
}
