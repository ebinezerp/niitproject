package ecommerce.database.daoImpl.order;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.database.dao.order.OrderDaoService;
import ecommerce.database.model.order.Order;

@Component
@Transactional
public class OrderDaoImpl implements OrderDaoService {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addOrder(Order order) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(order);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean deleteOrder(Order order) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(order);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean updateOrder(Order order) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(order);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public List<Order> getOrderListByCustomerId(long customerId) {
		// TODO Auto-generated method stub
	    try {
			return sessionFactory.getCurrentSession().createQuery("from Order where customer_customer_id=:id",Order.class).setParameter("id",customerId).list();
		} catch (HibernateException e) {
			// TODO: handle exception
			return null;
		}
	}

}
