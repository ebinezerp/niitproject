package ecommerce.database.dao;

import ecommerce.database.model.Vendor;

public interface VendorDaoService {

	public abstract boolean addVendor(Vendor vendor);
	public abstract boolean deleteVendor(Vendor vendor);
	public abstract boolean editVendor(Vendor vendor);
	public abstract Vendor getVendorById(long vendor_id);
	public abstract Vendor getVendorByEmail(String vendor_email);
	public abstract Vendor vendorLogin(String vendor_email,String vendor_password);
}
