package ecommerce.database.dao.products;

import java.util.List;

import ecommerce.database.model.products.Watch;

public interface WatchDaoService {
	public abstract boolean addWatch(Watch watch);
	public abstract boolean deleteWatch(Watch watch);
	public abstract boolean updateWatch(Watch watch);
	public abstract Watch retrieveWatchById(long productId);
	public abstract List<Watch> getAllWatches();
}
