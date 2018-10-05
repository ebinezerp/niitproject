package ecommerce.database.daoImpl.cart;

import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.database.dao.cart.CartDaoService;
import ecommerce.database.model.cart.Cart;
import ecommerce.database.model.cart.CartItems;

@Component
@Transactional
public class CartDaoImpl implements CartDaoService {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addCart(Cart cart) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(cart);
			return true;
			
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;	
		}
		
	}

	@Override
	public boolean updateCart(Cart cart) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
		
	}

	@Override
	public boolean deleteCart(Cart cart) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(cart);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;	
		}
		
	}

	@Override
	public Cart getCartByCustId(long customerId) {
		System.out.println(customerId);
		try {
			return (Cart)sessionFactory.getCurrentSession().createQuery("from Cart where customer_customer_id=:id").setParameter("id",customerId).getSingleResult();
		} catch (HibernateException | NoResultException  e) {
			
			// TODO: handle exception
			return null;	
		}

	}
	
	
	
}
