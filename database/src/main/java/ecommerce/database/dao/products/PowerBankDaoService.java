package ecommerce.database.dao.products;

import java.util.List;

import ecommerce.database.model.products.PowerBank;

public interface PowerBankDaoService {
	public abstract boolean addPowerBank(PowerBank powerBank);
	public abstract boolean deletePowerBank(PowerBank powerBank);
	public abstract boolean updatePowerBank(PowerBank powerBank);
	public abstract PowerBank retrievePowerBankById(long productId);
	public abstract List<PowerBank> getAllPowerBanks();

}
