package ecommerce.database.dao;

import java.util.List;

import ecommerce.database.model.Product;
import ecommerce.database.model.SubCategory;
import ecommerce.database.model.Vendor;

public interface ProductDaoService {
	
	public abstract boolean addProduct(Product product);
	public abstract boolean deleteProduct(Product product);
    public abstract boolean updateProduct(Product product);
    public abstract List<Product> getAllProducts(Vendor vendor);
    public abstract int getSubCategoryId(long productId);
   // public abstract Product getProduct(int productId);
}
