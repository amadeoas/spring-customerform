package com.aas.samples.customerform.service;

import java.util.Collection;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.aas.samples.customerform.model.Customer;


/**
 * Mostly used as a facade so all controllers have a single point of entry.
 *
 * @author Amadeo Asco
 */
public interface CustomerService {

	/**
	 * Adds the customer's details specified.
	 * 
	 * @param customer the customer's details.
	 * @throws DataAccessException when it has been an access problem.
	 */
	void add(Customer customer) throws DataAccessException;

	/**
	 * Adds the customers' details specified.
	 * 
	 * @param customers the customers' details.
	 * @throws DataAccessException when it has been an access problem.
	 */
	void add(List<Customer> customers) throws DataAccessException;

	/**
	 * Deletes the customer's details specified.
	 * 
	 * @param customerId the customer's Id.
	 * @throws DataAccessException when it has been an access problem.
	 */
	void delete(int customerId) throws DataAccessException;

	/**
	 * Looks for the customer with the specified ID.
	 * 
	 * @param customerId the customer's ID.
	 * @return the the customer with the specified ID.
	 * @throws DataAccessException when it has been an access problem.
	 */
    Customer findCustomer(int customerId) throws DataAccessException;

	/**
	 * @return all the customer details.
	 * @throws DataAccessException when it has been an access problem.
	 */
	Collection<Customer> getAllCustomers() throws DataAccessException;

	/**
	 * Updates the customer's details with those provided.
	 * 
	 * @param customer the customer's details.
	 * @throws DataAccessException when it has been an access problem.
	 */
	void update(Customer customer) throws DataAccessException;

}
