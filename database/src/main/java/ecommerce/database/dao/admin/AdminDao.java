package ecommerce.database.dao.admin;

import java.util.List;
import java.util.Set;

import ecommerce.database.model.Vendor;
import ecommerce.database.model.admin.Admin;

public interface AdminDao {

	public abstract boolean addAdmin(Admin admin);
	public abstract boolean deleteAdmin(Admin admin);
	public abstract Admin adminLogin(String email,String password);
	public abstract List<Vendor> getVendors();
}
