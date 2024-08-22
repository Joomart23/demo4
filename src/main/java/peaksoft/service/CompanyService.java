package peaksoft.service;

import peaksoft.entiti.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    void save(Company group);
    void delete(Long id);
    Company update(Long id ,Company group);
    void getById(Long id);

}
