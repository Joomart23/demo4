package peaksoft.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entiti.Company;
import peaksoft.repository.CompanyRepository;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class CompanyRepositoryImpl  implements CompanyRepository  {
    @PersistenceContext
    private final EntityManager em;

    @Override
    public List<Company> getAllCompanies() {
        return em.createQuery("from Company", Company.class).getResultList();
    }

    @Override
    public void save(Company group) {
        em.persist(group);

    }

    @Override
    public void delete(Long id) {
        Company group = em.find(Company.class, id);
        em.remove(group);

    }

    @Override
    public Company update(Long id, Company group) {

        return null;
    }

    @Override
    public void getById(Long id) {

    }
}