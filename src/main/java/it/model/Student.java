package it.model;

import it.controller.studyformat.StudyFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String email;

    private String first_name;

    private String last_name;

    //online or offline
    private StudyFormat studyFormat;

    @ManyToOne
    private Groups groups;
}
