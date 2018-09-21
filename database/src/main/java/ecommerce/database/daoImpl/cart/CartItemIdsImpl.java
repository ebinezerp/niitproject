package ecommerce.database.daoImpl.cart;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.database.dao.cart.CartItemIdsDaoService;
import ecommerce.database.model.cart.CartItemIds;

@Component
@Transactional
public class CartItemIdsImpl implements CartItemIdsDaoService{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addCartItemIds(CartItemIds cartItemIds) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(cartItemIds);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean deleteCartItemIds(CartItemIds cartItemIds) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(cartItemIds);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean updateCartItemIds(CartItemIds cartItemIds) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(cartItemIds);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean deleteAllRelatedCartItemIds(long cartItemsId) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().createQuery("delete from CartItemIds where cartItems_cartItems_id=:id").setParameter("id",cartItemsId);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public List<CartItemIds> getAllRelatedCartItemIds(long cartItemsId) {
		// TODO Auto-generated method stub
		try {
		return	sessionFactory.getCurrentSession().createQuery("from CartItemIds where cartItems_cartItemsId=:id",CartItemIds.class).setParameter("id",cartItemsId).list();
		} catch (HibernateException e) {
			// TODO: handle exception
			return null;
		}
	}

}
