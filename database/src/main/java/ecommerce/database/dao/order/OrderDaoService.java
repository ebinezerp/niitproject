package ecommerce.database.dao.order;

import java.util.List;

import ecommerce.database.model.order.Order;

public interface OrderDaoService {
	
	public abstract boolean addOrder(Order order);
	public abstract boolean deleteOrder(Order order);
	public abstract boolean updateOrder(Order order);
	public abstract List<Order> getOrderListByCustomerId(long customerId);
	
}
