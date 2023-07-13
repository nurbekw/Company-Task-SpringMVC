package it.repository.impl;

import it.model.Group;
import it.model.Student;
import it.repository.StudentRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class StudentRepositoryImpl implements StudentRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.save( student );
    }

    public List<Student> findAllStudent() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select m from Student m", Student.class).getResultList();
    }

    public Student findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get( Student.class,id );
    }

    public void deleteById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Student where id=:studentId").setParameter("studentId",id).executeUpdate();
    }

    public void updateById(Long id, Student newStudent) {
        Session session = sessionFactory.getCurrentSession();
        Student student = findById(id);
        student.setEmail( newStudent.getEmail() );
        student.setFirst_name( newStudent.getFirst_name() );
        student.setLast_name( newStudent.getLast_name() );
        student.setStudyFormat( newStudent.getStudyFormat() );
        session.merge( student );
    }

    public void clear() {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Student ").executeUpdate();
    }
}
