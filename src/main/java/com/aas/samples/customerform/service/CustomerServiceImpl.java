package com.aas.samples.customerform.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.aas.samples.customerform.model.Customer;
import com.aas.samples.customerform.repository.CustomerRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Mostly used as a facade for all CustomerProduct controllers
 * Also a placeholder for @Transactional and @Cacheable annotations.
 *
 * @author Amadeo Asco
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    
    @Autowired
    public CustomerServiceImpl(final CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

	@Override
	public void add(Customer customer) throws DataAccessException {
		this.customerRepository.add(customer);
	}

	@Override
	public void add(List<Customer> customers) throws DataAccessException {
		this.customerRepository.add(customers);
	}

	@Override
	public void delete(final int customerId) throws DataAccessException {
		this.customerRepository.delete(customerId);
	}

	@Override
	public Customer findCustomer(int customerId) throws DataAccessException {
		return this.customerRepository.findById(customerId);
	}

    @Override
    @Transactional(readOnly = true)
    public Collection<Customer> getAllCustomers() throws DataAccessException {
    	return this.customerRepository.findAll();
    }

	@Override
	public void update(final Customer customer) throws DataAccessException {
		this.customerRepository.update(customer);
	}

}
