package ecommerce.database.dao.products;

import java.util.List;

import ecommerce.database.model.products.Laptop;

public interface LaptopDaoService {
	
	public abstract boolean addLaptop(Laptop laptop);
	public abstract boolean deleteLaptop(Laptop laptop);
	public abstract boolean updateLaptop(Laptop laptop);
	public abstract Laptop retrieveLaptopById(long productId);
    public abstract List<Laptop> getAllLaptops();
}
