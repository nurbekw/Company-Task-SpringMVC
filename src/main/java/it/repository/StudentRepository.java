package it.repository;

import it.model.Course;
import it.model.Student;

import java.util.List;

public interface StudentRepository {
    void saveStudent(Student student);

    List<Student> findAllStudent();

    Student findById(Long id);

    void deleteById(Long id);

    void updateById(Long id,Student newStudent);

    void clear();
}
