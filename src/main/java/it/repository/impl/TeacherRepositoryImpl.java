package it.repository.impl;

import it.model.Company;
import it.model.Teacher;
import it.repository.TeacherRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TeacherRepositoryImpl implements TeacherRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveTeacher(Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();
        session.save(teacher);
    }

    public List<Teacher> findAllTeacher() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select m from Teacher m", Teacher.class).getResultList();
    }

    public Teacher findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get( Teacher.class,id );
    }

    public void deleteById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Teacher where id=:teacherId").setParameter("teacherId",id).executeUpdate();
    }

    public void updateById(Long id, Teacher newTeacher) {
        Session session = sessionFactory.getCurrentSession();
        Teacher teacher = findById(id);
        teacher.setEmail( newTeacher.getEmail() );
        teacher.setFirst_name( newTeacher.getFirst_name() );
        teacher.setLast_name( newTeacher.getLast_name() );
        session.merge(teacher);
    }

    public void clear() {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Teacher").executeUpdate();
    }
}
