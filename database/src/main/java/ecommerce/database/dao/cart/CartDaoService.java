package ecommerce.database.dao.cart;

import java.util.List;

import ecommerce.database.model.Customer;
import ecommerce.database.model.cart.Cart;
import ecommerce.database.model.cart.CartItems;

public interface CartDaoService {

	public abstract boolean addCart(Cart cart);
	public abstract boolean updateCart(Cart cart);
	public abstract boolean deleteCart(Cart cart);
	public abstract Cart getCartByCustId(long customerId);
}
