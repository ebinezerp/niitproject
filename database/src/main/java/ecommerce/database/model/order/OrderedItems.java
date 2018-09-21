package ecommerce.database.model.order;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Entity
@Component("OrderedItems")
public class OrderedItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderedItemsId;
	private int quantity;
	private int unitPrice;
	private int totalPrice;
	@ManyToOne
	private Order order;
	@OneToMany(mappedBy = "orderedItems", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<OrderedItemIds> orderedItemIdsList;

	public long getOrderedItemsId() {
		return orderedItemsId;
	}

	public void setOrderedItemsId(long orderedItemsId) {
		this.orderedItemsId = orderedItemsId;
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

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<OrderedItemIds> getOrderedItemIdsList() {
		return orderedItemIdsList;
	}

	public void setOrderedItemIdsList(List<OrderedItemIds> orderedItemIdsList) {
		this.orderedItemIdsList = orderedItemIdsList;
	}

}
