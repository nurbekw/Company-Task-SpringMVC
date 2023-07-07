package it.repository;

import it.model.Course;
import it.model.Group;

import java.util.List;

public interface GroupRepository {
    void saveGroup(Group group);

    List<Group> findAllGroup();

    Group findById(Long id);

    void deleteById(Long id);

    void updateById(Long id,Group newGroup);

    void clear();
}
