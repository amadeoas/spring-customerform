package com.aas.samples.customerform.repository.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

//import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;

import com.aas.samples.customerform.model.Customer;
import com.aas.samples.customerform.repository.CustomerRepository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * JPA implementation of the {@link CustomerRepository} interface.
 *
 * @author Amadeo Asco
 */
@Repository
public class JpaCustomerRepositoryImpl implements CustomerRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
//    @Cacheable(value = "customers")
    @SuppressWarnings("unchecked")
    public Collection<Customer> findAll() {
    	final Query query = this.em.createQuery(
    			"SELECT c " 
    		  + "FROM Customer c " 
    		  + "ORDER BY c.lastName, c.firstName");
    	
    	return query.getResultList();
    }

	@Override
	public Customer findById(int customerId) throws DataAccessException {
		return this.em.find(Customer.class, customerId);
	}

	@Override
	@Transactional
	public void update(final Customer customer) throws DataAccessException {
    	final Query query = this.em.createQuery(
    			"UPDATE Customer "
    		  + "SET id = :p, firstName = :fn, lastName = :ln "
    		  + "WHERE id = :p" );

    	query.setParameter("fn", customer.getFirstName())
    			.setParameter("ln", customer.getLastName())
    			.setParameter("p", customer.getId())
    			.executeUpdate();
	}

	@Override
	@Transactional
	public void delete(final int customerId) throws DataAccessException {
    	final Query query = this.em.createQuery(
    			"DELETE FROM Customer AS c "
    		  + "WHERE c.id = :p");

    	query.setParameter("p", customerId).executeUpdate();
	}

	@Override
	@Transactional
	public void add(final Customer customer) throws DataAccessException {
		// Should check if it does already exist
		this.em.persist(customer);
	}

}
