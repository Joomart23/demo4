package peaksoft.service.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entiti.Group;
import peaksoft.repository.GroupRepository;
import peaksoft.service.GroupService;

import java.util.List;
@Repository
@Transactional
@RequiredArgsConstructor
public class GroupServiceImpl  implements GroupService {
  private final  GroupRepository groupRepository;
    @Override
    public List<Group> getAllCompanies() {
        return groupRepository.getAllCompanies();
    }

    @Override
    public void save(Group company) {
      groupRepository.save(company);

    }

  @Override
  public void delete(Long id) {
      groupRepository.delete(id);
  }

  @Override
  public Group newGroup(Long id, Group newCompany) {
    return groupRepository.update(id, newCompany);
  }

  @Override
  public Group getGroup(Long id) {
     groupRepository.getById(id);
    return null;
  }

}