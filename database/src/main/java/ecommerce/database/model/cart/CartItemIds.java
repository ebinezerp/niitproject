package ecommerce.database.model.cart;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

import ecommerce.database.model.NumberOfProducts;

@Entity
@Component("CartItemIds")
public class CartItemIds {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cartItemIdsId;
	@OneToOne
	private NumberOfProducts numberOfProducts;
	@ManyToOne
	private CartItems cartItems;

	public CartItems getCartItems() {
		return cartItems;
	}

	public void setCartItems(CartItems cartItems) {
		this.cartItems = cartItems;
	}

	public long getCartItemIdsId() {
		return cartItemIdsId;
	}

	public void setCartItemIdsId(long cartItemIdsId) {
		this.cartItemIdsId = cartItemIdsId;
	}

	public NumberOfProducts getNumberOfProducts() {
		return numberOfProducts;
	}

	public void setNumberOfProducts(NumberOfProducts numberOfProducts) {
		this.numberOfProducts = numberOfProducts;
	}

}
