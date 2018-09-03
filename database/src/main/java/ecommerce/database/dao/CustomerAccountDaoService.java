package ecommerce.database.dao;

import ecommerce.database.model.CustomerAccount;

public interface CustomerAccountDaoService {
	public abstract boolean addCustomerAccount(CustomerAccount customerAccount);
	public abstract boolean deleteCustomerAccount(CustomerAccount customerAccount);
	public abstract CustomerAccount getCustomerAccountById(long account_id);

}
