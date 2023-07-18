package it.repository.impl;

import it.model.Groups;
import it.repository.GroupRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class GroupRepositoryImpl implements GroupRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveGroup(Groups group) {
        Session session = sessionFactory.getCurrentSession();
        session.save( group );
    }

    public List<Groups> findAllGroup() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select m from Groups m",Groups.class).getResultList();
    }

    public Groups findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get( Groups.class,id );
    }

    public void deleteById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Groups where id=:groupId").setParameter("groupId",id).executeUpdate();
    }

    public void updateById(Long id, Groups newGroup) {
        Session session = sessionFactory.getCurrentSession();
        Groups group = findById( id );
        group.setGroupName( newGroup.getGroupName() );
        group.setDateOfStart( newGroup.getDateOfStart() );
        group.setDateOfFinish( newGroup.getDateOfFinish() );
        session.merge( group );
    }

    public void clear() {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Groups ").executeUpdate();
    }
}
