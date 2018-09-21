package ecommerce.database.daoImpl.order;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.database.dao.order.OrderedItemsDaoService;
import ecommerce.database.model.order.OrderedItems;

@Component
@Transactional
public class OrderedItemsDaoImpl implements OrderedItemsDaoService {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addOrderedItems(OrderedItems orderedItems) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(orderedItems);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean deleteOrderedItems(OrderedItems orderedItems) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(orderedItems);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean updateOrederedItems(OrderedItems orderedItems) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(orderedItems);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public List<OrderedItems> getOrderedItemsList(long orderId) {
		// TODO Auto-generated method stub
        try {
		return	sessionFactory.getCurrentSession().createQuery("from OrderedItems where order_orderId=:id",OrderedItems.class).setParameter("id",orderId).list();
			
		} catch (HibernateException e) {
			// TODO: handle exception
			return null;
		}		
	}

}
