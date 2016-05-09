package com.aas.samples.customerform.repository.jdbc;

import com.aas.samples.customerform.model.Customer;
import com.aas.samples.customerform.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


/**
 * A simple JDBC-based implementation of the {@link CustomerRepository} 
 * interface.
 *
 * @author Amadeo Asco
 */
@Repository
public class JdbcCustomerRepositoryImpl implements CustomerRepository {

    private JdbcTemplate jdbcTemplate;


	@Override
	public void add(final Customer customer) throws DataAccessException {
		this.jdbcTemplate.update(
				"INSERT INTO "
			  + "customers "
			  + "(first_name, last_name) "
	          + "VALUES " + "(?, ?)",
	          new Object[] {customer.getFirstName(), customer.getLastName()});
	}

	@Override
	public void add(List<Customer> customers) throws DataAccessException {
		for (final Customer customer : customers) {
			add(customer);
		}
	}

	@Override
	public void delete(final int customerId) throws DataAccessException {
		int numRows = this.jdbcTemplate.update(
				"DELETE FROM customers AS c "
			  + "WHERE c.id = " + customerId);
		
		if (numRows != 1) {
			throw new DataAccessException("Fialed to delete customer's deatils with ID " + customerId) {
				private static final long serialVersionUID = 6080019203735510870L;
			};
		}
	}

    @Autowired
    public JdbcCustomerRepositoryImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Collection<Customer> findAll() throws DataAccessException {
        final Collection<Customer> customers = new ArrayList<>();

        // Retrieve the list of all customers
        customers.addAll(this.jdbcTemplate.queryForList(
            "SELECT * " 
          + "FROM customers "
          + "ORDER BY c.first_name, c.last_name",
          Customer.class));
        
        return customers;
    }
    
    @Override
    public Customer findById(int customerId) throws DataAccessException {
        // Retrieve the customer with the specified ID
        Customer customer = this.jdbcTemplate.queryForObject(
            "SELECT * " 
          + "FROM customers AS c " 
          + "WHERE c.id = " + customerId,
          Customer.class);
          
        return customer;
    }

	@Override
	public void update(final Customer customer) throws DataAccessException {
        this.jdbcTemplate.update(
                "UPDATE * " 
              + "FROM customers AS c ",
              customer);
	}

}
