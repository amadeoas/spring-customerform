package com.aas.samples.customerform.repository.file;


import com.aas.samples.customerform.model.Customer;
import com.aas.samples.customerform.repository.CustomerRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;


/**
 * A simple File-based implementation of the {@link CustomerRepository} 
 * interface.
 *
 * @author Amadeo Asco
 */
@Repository
public class FileCustomerRepositoryImpl implements CustomerRepository {
	
	private static final Log LOGGER = LogFactory.getLog(FileCustomerRepositoryImpl.class);

	private static final String FILENAME = "";

	// CopyOnWriteArrayList is ideal for the exact scenario where ArrayList 
	// fails: read-often and write-rarely collections
	private static CopyOnWriteArrayList<Customer> customers = loadCustomers();


    @Autowired
    public FileCustomerRepositoryImpl() {
    }

	@Override
	public void add(final Customer customer) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(final List<Customer> customers) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(final int customerId) throws DataAccessException {
		// Remove specified customer
		FileCustomerRepositoryImpl.customers.stream().filter(c -> {return c.getId() != customerId;});
		
		// Save into the file
		saveCustomers();
	}

    public Collection<Customer> findAll() throws DataAccessException {
    	// It may be better if all elements in the collection were read only
    	return Collections.unmodifiableList(FileCustomerRepositoryImpl.customers);
    }
    
    @Override
    public Customer findById(int customerId) throws DataAccessException {
        // Retrieve the customer with the specified ID
    	for (int index = 0; index < FileCustomerRepositoryImpl.customers.size(); 
				++index) {
			final Customer c = FileCustomerRepositoryImpl.customers.get(index);

			if (customerId == c.getId()) {
		    	final Customer customer = new Customer();

		    	customer.setId(c.getId());
		    	customer.setFirstName(c.getFirstName());
		    	customer.setLastName(c.getLastName());

        		return customer;
        	}
        }
          
        return null;
    }

	@Override
	public void update(final Customer customer) throws DataAccessException {
		if (customer == null) {
			return;
		}
		
		final Customer newCustomer = new Customer();

		newCustomer.setId(customer.getId());
		newCustomer.setFirstName(customer.getFirstName());
		newCustomer.setLastName(customer.getLastName());
		for (int index = 0; index < FileCustomerRepositoryImpl.customers.size(); 
				++index) {
			final Customer c = FileCustomerRepositoryImpl.customers.get(index);

			if (newCustomer.getId() == c.getId()) {
        		FileCustomerRepositoryImpl.customers.set(index, newCustomer);

        		break;
        	}
        }

		// Save into the file
		saveCustomers();
	}
	
	/**
	 * Loads the customers from the corresponding file.
	 * 
	 * @return the read list of customers.
	 */
	private static CopyOnWriteArrayList<Customer> loadCustomers() {
		final String filename = "";
		CopyOnWriteArrayList<Customer> data;

		try {
			final Gson gson = new Gson();
			final JsonReader reader = new JsonReader(new FileReader(filename));

			data = gson.fromJson(reader, Customer.class);
		} catch (final IOException ioe) {
			LOGGER.error("Failed to load customers from file " + filename, 
					ioe);
			data = new CopyOnWriteArrayList<>();
		} // end try

		return data;
	}
	
	/**
	 * Saves the customers into the corresponding file in Json format.
	 * 
	 * This will not be valid if several instances of this implementation are 
	 * run by different processes.
	 */
	private static synchronized void saveCustomers() {
		Writer out = null;

		try {
	        final Gson gson = new GsonBuilder().setPrettyPrinting().create();
	        String strJson;

	        out = new BufferedWriter(new FileWriter(FILENAME));
	        strJson = gson.toJson(FileCustomerRepositoryImpl.customers);
	        out.append(strJson);
	    } catch (final IOException ioe) {
	    	LOGGER.error("Failed to save customers in Json into file " 
	    			+ FILENAME, ioe);
	    } finally {
	    	if (out != null) {
	    		try {
	    			out.close();
	    		} catch (final IOException ioe) {
	    			// Nothing to do
	    		}
	    	}
	    } // end try
	}

}
