package ecommerce.database.dao.products;

import java.util.List;

import ecommerce.database.model.products.Mobile;

public interface MobileDaoService {
	
	public abstract boolean addMobile(Mobile mobile);
	public abstract boolean deleteMobile(Mobile mobile);
	public abstract boolean updateMobile(Mobile mobile);
	public abstract Mobile getMobile(long productId);
	public abstract List<Mobile> getAllMobiles();

}
