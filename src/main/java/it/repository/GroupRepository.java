package it.repository;

import it.model.Groups;
import java.util.List;

public interface GroupRepository {
    void saveGroup(Groups group);

    List<Groups> findAllGroup();

    Groups findById(Long id);

    void deleteById(Long id);

    void updateById(Long id,Groups newGroup);

    void clear();
}
