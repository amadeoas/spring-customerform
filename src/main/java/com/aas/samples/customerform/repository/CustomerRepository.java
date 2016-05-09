package com.aas.samples.customerform.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.aas.samples.customerform.model.Customer;


/**
 * Repository class for <code>Customer</code> domain objects. All method names 
 * are compliant with Spring Data naming conventions so this interface can 
 * easily be extended for Spring Data, see here: 
 * http://static.springsource.org/spring-data/jpa/docs/current/reference/html/jpa.repositories.html#jpa.query-methods.query-creation
 *
 * @author Amadeo Asco
 */
public interface CustomerRepository {

	/**
	 * Adds the specified ustomer's details.
	 * 
	 * @param customer the customer's details.
	 * @throws DataAccessException when the data access failed.
	 */
	void add(final Customer customer) throws DataAccessException;
	
	/**
	 * Adds the specified ustomer's details.
	 * 
	 * @param customers the customers' details.
	 * @throws DataAccessException when the data access failed.
	 */
	void add(final List<Customer> customers) throws DataAccessException;

	/**
	 * Deletes the specified customer's details.
	 * 
	 * @param customerId the customer's ID.
	 * @throws DataAccessException when the data access failed.
	 */
	void delete(final int customerId) throws DataAccessException;

    /**
     * Retrieves all <code>Customer</code>s from the data store.
     *
     * @return a <code>Collection</code> of <code>Customer</code>s.
	 * @throws DataAccessException when the data access failed.
     */
    Collection<Customer> findAll() throws DataAccessException;

    /**
     * Retrieves a <code>Customer</code> from the data store by id.
     *
     * @param id the id to search for.
     * @return the <code>Customer</code> if found.
	 * @throws DataAccessException when the data access failed.
     */
	Customer findById(int id) throws DataAccessException;

	/**
	 * Saves the new customer's details provided.
	 * 
	 * @param customer the customer details.
	 * @throws DataAccessException when the data access failed.
	 */
	void update(final Customer customer) throws DataAccessException;
}
