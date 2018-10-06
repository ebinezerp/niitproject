package ecommerce.database.dao.cart;

import java.util.List;

import ecommerce.database.model.cart.CartItems;

public interface CartItemsDaoService {

	public abstract boolean addCartItem(CartItems cartItems);
	public abstract boolean deleteCartItem(CartItems cartItems);
	public abstract boolean updateCartItem(CartItems cartItems);
	public abstract List<CartItems> getCartItemsByCartId(long cartId);
	public abstract boolean deleteAllRelatedCartItems(long cartId);
	public abstract  CartItems getCartItemByCartId(long cartId);
	public abstract CartItems getCartItemByCartItemsId(long cartItemsId);
}
