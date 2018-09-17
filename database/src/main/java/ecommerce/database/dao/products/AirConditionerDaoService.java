package ecommerce.database.dao.products;

import java.util.List;

import ecommerce.database.model.products.AirConditioner;

public interface AirConditionerDaoService {
	
	public abstract boolean addAirConditioner(AirConditioner airConditioner);
	public abstract boolean deleteAirConditioner(AirConditioner airConditioner);
	public abstract boolean updateAirConditioner(AirConditioner airConditioner);
	public abstract AirConditioner retrieveAirConditionerById(long productId);
	public abstract List<AirConditioner> getAllAirConditioners();

}
