package ecommerce.database.dao;

import ecommerce.database.model.VendorAccountDetails;

public interface VendorAccountDaoService {
	
	public abstract boolean addVendorAccount(VendorAccountDetails accountDetails);
    public abstract boolean editVendorAccount(VendorAccountDetails accountDetails);
    public abstract boolean deleteVendorAccount(VendorAccountDetails accountDetails);
    public abstract VendorAccountDetails getVendorAccountById(long account_id);
    public abstract VendorAccountDetails getVendorAccountByAccountNumber(String account_number);    
}
