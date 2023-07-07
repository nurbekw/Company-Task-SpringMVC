package it.repository;

import it.model.Course;
import it.model.Teacher;

import java.util.List;

public interface TeacherRepository {
    void saveTeacher(Teacher teacher);

    List<Teacher> findAllTeacher();

    Teacher findById(Long id);

    void deleteById(Long id);

    void updateById(Long id,Teacher newTeacher);

    void clear();
}
