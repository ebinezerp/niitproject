package ecommerce.database.daoImpl.cart;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.tags.form.HiddenInputTag;

import ecommerce.database.dao.cart.CartItemsDaoService;
import ecommerce.database.model.cart.CartItems;

@Component
@Transactional
public class CartItemsDaoImpl implements CartItemsDaoService {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addCartItem(CartItems cartItems) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(cartItems);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}

	}

	@Override
	public boolean deleteCartItem(CartItems cartItems) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(cartItems);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean updateCartItem(CartItems cartItems) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(cartItems);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public List<CartItems> getCartItemsByCartId(long cartId) {
		// TODO Auto-generated method stub
		try {
			return sessionFactory.getCurrentSession()
					.createQuery("from CartItems where cart_cartId=:id", CartItems.class).setParameter("id", cartId)
					.list();
		} catch (HibernateException e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public boolean deleteAllRelatedCartItems(long cartId) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().createQuery("delete from CartItems where cart_cartId=:id")
					.setParameter("id", cartId).executeUpdate();
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}

	}

	@Override
	public CartItems getCartItemByCartId(long cartId) {
		// TODO Auto-generated method stub
		try {
		return 	(CartItems)sessionFactory.getCurrentSession().createQuery("from CartItems where cart_cartId=:id").setParameter("id", cartId).getSingleResult();
		} catch (HibernateException e) {
			// TODO: handle exception
			return null;
		}
		
		
		
	}

	@Override
	public CartItems getCartItemByCartItemsId(long cartItemsId) {
		// TODO Auto-generated method stub
		try {
			return 	(CartItems)sessionFactory.getCurrentSession().createQuery("from CartItems where cartItemsId=:id").setParameter("id", cartItemsId).getSingleResult();
			} catch (HibernateException e) {
				// TODO: handle exception
				return null;
			}
	}

}
