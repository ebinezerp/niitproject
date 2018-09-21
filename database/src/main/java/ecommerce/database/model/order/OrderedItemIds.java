package ecommerce.database.model.order;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

import ecommerce.database.model.NumberOfProducts;

@Entity
@Component
public class OrderedItemIds {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderedItemIdsId;
	@OneToOne
	private NumberOfProducts numberOfProducts;
	@ManyToOne
	private OrderedItems orderedItems;

	public long getOrderedItemIdsId() {
		return orderedItemIdsId;
	}

	public void setOrderedItemIdsId(long orderedItemIdsId) {
		this.orderedItemIdsId = orderedItemIdsId;
	}

	public NumberOfProducts getNumberOfProducts() {
		return numberOfProducts;
	}

	public void setNumberOfProducts(NumberOfProducts numberOfProducts) {
		this.numberOfProducts = numberOfProducts;
	}

	public OrderedItems getOrderedItems() {
		return orderedItems;
	}

	public void setOrderedItems(OrderedItems orderedItems) {
		this.orderedItems = orderedItems;
	}
}
