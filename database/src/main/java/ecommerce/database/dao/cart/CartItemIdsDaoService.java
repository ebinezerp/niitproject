package ecommerce.database.dao.cart;

import java.util.List;

import ecommerce.database.model.cart.CartItemIds;

public interface CartItemIdsDaoService {
	
	public abstract boolean addCartItemIds(CartItemIds cartItemIds);
	public abstract boolean deleteCartItemIds(CartItemIds cartItemIds);
	public abstract boolean updateCartItemIds(CartItemIds cartItemIds);
	public abstract boolean deleteAllRelatedCartItemIds(long cartItemsId);
	public abstract List<CartItemIds> getAllRelatedCartItemIds(long cartItemsId);
}
