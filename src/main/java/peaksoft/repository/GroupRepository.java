package peaksoft.repository;

import peaksoft.entiti.Group;

import java.util.List;

public interface GroupRepository {
    List<Group> getAllCompanies();
    void save(Group group);
    void delete(Long id);
    Group update(Long id ,Group group);
    void getById(Long id);



}
