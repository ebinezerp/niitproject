package ecommerce.database.dao.products;

import java.util.List;

import ecommerce.database.model.products.Television;

public interface TelevisionDaoService {

	public abstract boolean addTelevision(Television television);
	public abstract boolean deleteTelevision(Television television);
	public abstract boolean updateTelevision(Television television);
	public abstract Television retrieveTelevisionById(long productId);
	public abstract List<Television> getAllTelevisions();
}
