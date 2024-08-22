package peaksoft.service;

import peaksoft.entiti.Group;
import peaksoft.entiti.Lesson;

import java.util.List;

public interface GroupService {
    List<Group> getAllCompanies();
    void save(Group company);
    void delete(Long id);
    Group newGroup(Long id, Group newCompany);
    Group getGroup(Long id);
}
