package com.aas.samples.customerform.web;

import com.aas.samples.customerform.model.Customer;
import com.aas.samples.customerform.service.CustomerService;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Controller used to access the customer's details.
 * 
 * @author Amadeo Asco
 */
@Controller
@RequestMapping("/customers")
public class CustomersController extends BaseController {

    private final CustomerService customerService;


    @Autowired
    public CustomersController(final CustomerService customerService) {
        this.customerService = customerService;
    }

	/**
     * <p>Retrieves a list of all the customers.</p>
     * 
     * <p>Expected HTTP GET and request '/customer'.</p>
     * 
     * @param lang the language.
     * @param model the model.
     * @return the template.
     */
    @RequestMapping(method = RequestMethod.GET)
    public String initList(@RequestParam(value="lang", required=false) String language, final Model model) {
    	final Collection<Customer> customers = this.customerService.getAllCustomers();

    	setLanguage(language, model);
    	model.addAttribute("customers", customers);

        return "customers/customersList";
    }

	/**
     * <p>Retrieves the view of the customer's details.</p>
     * 
     * <p>Expected HTTP GET and request '/customer/view/{customerId}'.</p>
     * 
     * @param lang the language.
     * @param customerId the customer's ID.
     * @param model the model.
     * @return the template.
     */
    @RequestMapping(value="/view/{customerId}", method = RequestMethod.GET)
    public String view(@RequestParam(value="lang", required=false) String language, 
    		@PathVariable final int customerId, final Model model) {
    	final Customer customer = this.customerService.findCustomer(customerId);

    	setLanguage(language, model);
    	model.addAttribute("customer", customer);

        return "customers/customerView";
    }

	/**
     * <p>Retrieves the add view of the customer's details.</p>
     * 
     * <p>Expected HTTP GET and request '/customer/view/{customerId}'.</p>
     * 
     * @param lang the language.
     * @param customerId the customer's ID.
     * @param model the model.
     * @return the template.
     */
    @RequestMapping(value="/addView/{customerId}", method = RequestMethod.GET)
    public String addView(@RequestParam(value="lang", required=false) String language, 
    		@PathVariable final int customerId, final Model model) {
    	final Customer customer = this.customerService.findCustomer(customerId);

    	setLanguage(language, model);
    	model.addAttribute("customer", customer);

        return "customers/customerAdd";
    }

	/**
     * <p>Retrieves the edit view of the customer's details.</p>
     * 
     * <p>Expected HTTP GET and request '/customer/edit/{customerId}'.</p>
     * 
     * @param lang the language.
     * @param model the model.
     * @return the template.
     */
    @RequestMapping(value="/edit/{customerId}", method = RequestMethod.GET)
    public String edit(@RequestParam(value="lang", required=false) String language, 
    		@PathVariable final int customerId, final Model model) {
    	final Customer customer = this.customerService.findCustomer(customerId);

    	setLanguage(language, model);
    	model.addAttribute("customer", customer);

        return "customers/customerEdit";
    }

	/**
     * <p>Saves the customer's details provided.</p>
     * 
     * <p>Expected HTTP GET and request '/customer/edit/{customerId}'.</p>
     * 
     * @param lang the language.
     * @param customer the customer's details.
     * @param model the model.
     * @return the template.
     */
    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String add(@RequestParam(value="lang", required=false) String language, 
    		final Customer customer, final Model model) {
    	this.customerService.add(customer);

        return initList(language, model);
    }

	/**
     * <p>Updates the customer's details provided.</p>
     * 
     * <p>Expected HTTP GET and request '/customer/edit/{customerId}'.</p>
     * 
     * @param lang the language.
     * @param customer the customer's details.
     * @param model the model.
     * @return the template.
     */
    @RequestMapping(value="/update/{customerId}", method = RequestMethod.POST)
    public String update(@RequestParam(value="lang", required=false) String language, 
    		@PathVariable final int customerId, final Customer customer, 
    		final Model model) {
    	customer.setId(customerId);
    	this.customerService.update(customer);

        return initList(language, model);
    }

	/**
     * <p>Deletes the specified customer.</p>
     * 
     * <p>Expected HTTP GET and request '/customer/edit/{customerId}'.</p>
     * 
     * @param lang the language.
     * @param customer the customer's details.
     * @param model the model.
     * @return the template.
     */
    @RequestMapping(value="/delete/{customerId}", method = RequestMethod.GET)
    public String delete(@RequestParam(value="lang", required=false) String language, 
    		@PathVariable final int customerId, final Model model) {
    	this.customerService.delete(customerId);

        return initList(language, model);
    }

}
