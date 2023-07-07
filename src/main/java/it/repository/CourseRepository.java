package it.repository;

import it.model.Course;

import java.util.List;

public interface CourseRepository {
   void saveCourse(Course course);

   List<Course> findAllCourse();

   Course findById(Long id);

   void deleteById(Long id);

   void updateById(Long id,Course newCourse);

   void clear();
}
