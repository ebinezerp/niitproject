package ecommerce.database.dao;

import ecommerce.database.model.Customer;

public interface CustomerDaoService {

	public abstract boolean addCustomer(Customer customer);
	public abstract boolean deleteCustomer(Customer customer);
	public abstract Customer getCustomerById(long customer_id);
}
