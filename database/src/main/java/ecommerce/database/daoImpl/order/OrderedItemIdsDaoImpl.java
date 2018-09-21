package ecommerce.database.daoImpl.order;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.database.dao.order.OrderedItemIdsDaoService;
import ecommerce.database.model.order.OrderedItemIds;

@Component
@Transactional
public class OrderedItemIdsDaoImpl implements OrderedItemIdsDaoService{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addOrderedItemIds(OrderedItemIds orderedItemIds) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(orderedItemIds);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean deleteOrderedItemIds(OrderedItemIds orderedItemIds) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(orderedItemIds);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean updateOrderedItemIds(OrderedItemIds orderedItemIds) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(orderedItemIds);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public List<OrderedItemIds> getOrderedItemIdsList(long orderedItemsId) {
		// TODO Auto-generated method stub
		try {
		return	sessionFactory.getCurrentSession().createQuery("from OrderedItemIds where orderedItems_orderedItemsId=:id",OrderedItemIds.class).setParameter("id", orderedItemsId).list();
		} catch (HibernateException e) {
			// TODO: handle exception
			return null;
		}
	}
	
}
