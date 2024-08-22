package peaksoft.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entiti.Company;
import peaksoft.repository.CompanyRepository;
import peaksoft.service.CompanyService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
private final CompanyRepository companyRepository;

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.getAllCompanies();
    }

    @Override
    public void save(Company group) {
        companyRepository.save(group);

    }

    @Override
    public void delete(Long id) {
        companyRepository.delete(id);

    }

    @Override
    public Company update(Long id, Company group) {

        return companyRepository.update(id, group);
    }

    @Override
    public void getById(Long id) {
        companyRepository.getById(id);

    }
}
