package it.repository;

import it.model.Company;

import java.util.List;

public interface CompanyRepository {
    void saveCompany(Company company);

    List<Company> findAllCompany();

    Company findById(Long id);

    void deleteById(Long id);

    void updateById(Long id,Company newCompany);

    void clear();
}
