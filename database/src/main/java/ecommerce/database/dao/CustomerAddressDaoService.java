package ecommerce.database.dao;

import ecommerce.database.model.CustomerAddress;

public interface CustomerAddressDaoService {

	public abstract boolean addCustomerAddress(CustomerAddress customerAddress);
	public abstract boolean deleteCustomerAddress(CustomerAddress customerAddress);
	public abstract CustomerAddress getCustomerAddressById(long address_id);
}
