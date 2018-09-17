package ecommerce.database.dao.products;

import java.util.List;

import ecommerce.database.model.products.EarPhone;

public interface EarPhoneDaoService {
	
	public abstract boolean addEarPhone(EarPhone earPhone);
    public abstract boolean deleteEarPhone(EarPhone  earPhone);
    public abstract boolean updateEarPhone(EarPhone earPhone);
    public abstract EarPhone retrieveEarPhoneById(long productId);
    public abstract List<EarPhone> getAllEarPhones();
}