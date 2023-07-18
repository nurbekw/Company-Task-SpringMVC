package it.repository.impl;

import it.model.Company;
import it.model.Course;
import it.repository.CompanyRepository;
import it.repository.CourseRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class CourseRepositoryImpl implements CourseRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private CompanyRepository companyRepository;

    public void saveCourse(Course course) {
        Session session = sessionFactory.getCurrentSession();
        session.save(course);
    }

    public List<Course> findAllCourse() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select m from Course m", Course.class).getResultList();
    }

    public Course findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get( Course.class,id );
    }

    public void deleteById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Course where id=:courseId").setParameter("courseId",id).executeUpdate();
    }

    public void updateById(Long id, Course newCourse) {
        Session session = sessionFactory.getCurrentSession();
        Course course = findById(id);
        course.setCourseName( newCourse.getCourseName() );
        course.setDuration( newCourse.getDuration() );
        session.merge( course );
    }

    public void clear() {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Course ").executeUpdate();
    }
}
