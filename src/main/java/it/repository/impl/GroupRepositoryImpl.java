package it.repository.impl;

import it.model.Group;
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

    public void saveGroup(Group group) {
        Session session = sessionFactory.getCurrentSession();
        session.save( group );
    }

    public List<Group> findAllGroup() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select m from Group m",Group.class).getResultList();
    }

    public Group findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get( Group.class,id );
    }

    public void deleteById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Group where id=:groupId").setParameter("groupId",id).executeUpdate();
    }

    public void updateById(Long id, Group newGroup) {
        Session session = sessionFactory.getCurrentSession();
        Group group = findById( id );
        group.setGroupName( newGroup.getGroupName() );
        group.setDateOfStart( newGroup.getDateOfStart() );
        group.setDateOfFinish( newGroup.getDateOfFinish() );
        session.merge( group );
    }

    public void clear() {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Group ").executeUpdate();
    }
}
