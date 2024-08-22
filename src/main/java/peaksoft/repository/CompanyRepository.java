package peaksoft.repository;

import peaksoft.entiti.Company;
import peaksoft.entiti.Group;

import java.util.List;

public interface CompanyRepository {
    List<Company> getAllCompanies();
    void save(Company group);
    void delete(Long id);
    Company update(Long id ,Company group);
    void getById(Long id);
}
