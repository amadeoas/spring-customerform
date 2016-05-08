package com.aas.samples.customerform.model;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * Simple JavaBean domain object representing a customer.
 *
 * @author Amadeo Asco
 */
@Entity
@Table(name = "customers")
public class Customer extends Person {

}
