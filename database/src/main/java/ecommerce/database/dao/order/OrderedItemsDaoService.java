package ecommerce.database.dao.order;

import java.util.List;

import ecommerce.database.model.order.OrderedItems;

public interface OrderedItemsDaoService {

	public abstract boolean addOrderedItems(OrderedItems orderedItems);
	public abstract boolean deleteOrderedItems(OrderedItems orderedItems);
	public abstract boolean updateOrederedItems(OrderedItems orderedItems);
	public abstract List<OrderedItems> getOrderedItemsList(long orderId);
}
