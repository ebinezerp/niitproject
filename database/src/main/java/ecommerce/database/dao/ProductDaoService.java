package ecommerce.database.dao;

import ecommerce.database.model.Product;

public interface ProductDaoService {
	
	public abstract boolean addProduct(Product product);
	public abstract boolean deleteProduct(Product product);
    public abstract boolean updateProduct(Product product);
}
