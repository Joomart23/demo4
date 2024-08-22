package peaksoft.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entiti.Group;
import peaksoft.repository.GroupRepository;

import java.util.List;
@Repository
@Transactional
@RequiredArgsConstructor
public class GroupRepositoryImpl  implements GroupRepository {
    @PersistenceContext
    private final EntityManager em;
    @Override
    public List<Group> getAllCompanies() {
        return  em.createQuery("select c from Group c", Group.class).getResultList();
    }

    @Override
    public void save(Group group) {
        em.persist(group);
    }

    @Override
    public void delete(Long id ) {
       Group group   =  em.find(Group.class, id);
        em.remove(group);

    }

    @Override
    public Group update( Long id,Group newGroup) {
        Group existingGroup = em.find(Group.class, id);
        if (existingGroup == null) {
            return null;
        }
        existingGroup.setGroupName(newGroup.getGroupName());
        existingGroup.setDescription(newGroup.getDescription());
        existingGroup.setImageLink(newGroup.getImageLink());
        return em.merge(existingGroup);

    }

    @Override
    public void getById(Long id) {
      Group  group =  em.find(Group.class, id);
        System.out.println(group);

    }

}

