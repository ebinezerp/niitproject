package ecommerce.database.dao.products;

import java.util.List;

import ecommerce.database.model.products.Shoe;

public interface ShoeDaoService {

	public abstract boolean addShoes(Shoe shoe);
	public abstract boolean deleteShoes(Shoe shoe);
	public abstract boolean updateShoes(Shoe shoe);
	public abstract Shoe retrieveShoesById(long productId);
	public abstract List<Shoe>  getAllShoes();
}
