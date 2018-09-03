package ecommerce.database.dao;

import ecommerce.database.model.VendorAddress;

public interface VendorAddressDaoService {
	
	public abstract boolean addVendorAddress(VendorAddress address);
	public abstract boolean deleteVendorAddress(VendorAddress address);
	public abstract boolean editVendorAddress(VendorAddress address);
	public abstract VendorAddress getVendorAddress(long address_id);

}
