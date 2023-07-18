package it.repository.impl;

import it.model.Company;
import it.repository.CompanyRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CompanyRepositoryImpl implements CompanyRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveCompany(Company company) {
        Session session = sessionFactory.getCurrentSession();
        session.save(company);
    }

    public List<Company> findAllCompany() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select m from Company m",Company.class).getResultList();
    }

    public Company findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get( Company.class,id );
    }

    public void deleteById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Company where id=:companyId").setParameter("companyId",id).executeUpdate();
    }

    public void updateById(Long id, Company newCompany) {
        Session session = sessionFactory.getCurrentSession();
        Company company = findById(id);
        company.setCompanyName( newCompany.getCompanyName() );
        company.setLocatedCounty( newCompany.getLocatedCounty() );
        session.merge(company);
    }

    public void clear() {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete from Company").executeUpdate();
    }


}
