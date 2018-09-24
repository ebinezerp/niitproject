package ecommerce.database.model.cart;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

import ecommerce.database.model.Product;

@Entity
@Component("CartItems")
public class CartItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cartItemsId;
	private int quantity;
	private int unitPrice;
	private int totalPrice;
	@ManyToOne
	private Cart cart;
	@OneToMany(mappedBy = "cartItems", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<CartItemIds> cartItemIdsList;	
	

	public long getCartItemsId() {
		return cartItemsId;
	}

	public void setCartItemsId(long cartItemsId) {
		this.cartItemsId = cartItemsId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public List<CartItemIds> getCartItemIdsList() {
		return cartItemIdsList;
	}

	public void setCartItemIdsList(List<CartItemIds> cartItemIdsList) {
		this.cartItemIdsList = cartItemIdsList;
	}

}
