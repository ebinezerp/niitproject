package ecommerce.database.dao.order;

import java.util.List;

import ecommerce.database.model.order.OrderedItemIds;

public interface OrderedItemIdsDaoService {

	public abstract boolean addOrderedItemIds(OrderedItemIds orderedItemIds);
	public abstract boolean deleteOrderedItemIds(OrderedItemIds orderedItemIds);
	public abstract boolean updateOrderedItemIds(OrderedItemIds orderedItemIds);
	public abstract List<OrderedItemIds> getOrderedItemIdsList(long OrderedItemsId);
}
