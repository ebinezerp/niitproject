package ecommerce.database.dao.products;

import java.util.List;

import ecommerce.database.model.products.Refrigerator;

public interface RefrigeratorDaoService {
	
	public abstract boolean addRefrigerator(Refrigerator refrigerator);
	public abstract boolean updateRefrigerator(Refrigerator refrigerator);
	public abstract boolean deleteRefrigerator(Refrigerator refrigerator);
	public abstract Refrigerator retrieveRefrigeratorById(long productId);
	public abstract List<Refrigerator> getAllRefrigerators();
}
