package ecommerce.database.dao.products;

import java.util.List;

import ecommerce.database.model.products.SSD;

public interface SSDDaoService {

	public abstract boolean addSSD(SSD ssd);
	public abstract boolean deleteSSD(SSD ssd);
	public abstract boolean updateSSD(SSD ssd);
	public abstract SSD retrieveSSDById(long productId);
	public abstract List<SSD> getAllSSD();
}
