package ecommerce.database.daoImpl.products;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.database.dao.products.ShoeDaoService;
import ecommerce.database.model.products.Shoe;

@Component
@Transactional
public class ShoeDaoImpl implements ShoeDaoService {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addShoes(Shoe shoe) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(shoe);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean deleteShoes(Shoe shoe) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(shoe);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean updateShoes(Shoe shoe) {
		// TODO Auto-generated method stub
     try {
		sessionFactory.getCurrentSession().update(shoe);
		return true;
	} catch (HibernateException e) {
		// TODO: handle exception
		return false;
	}
	}

	@Override
	public Shoe retrieveShoesById(long productId) {
		// TODO Auto-generated method stub
		try {
		return (Shoe)sessionFactory.getCurrentSession().createQuery("from Shoe where productId=:id").setParameter("id",productId).getSingleResult();
		} catch (HibernateException e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public List<Shoe> getAllShoes() {
		// TODO Auto-generated method stub
		try {
		return	sessionFactory.getCurrentSession().createCriteria(Shoe.class).list();
		
		} catch (HibernateException e) {
			// TODO: handle exception
			return null;
		}
	}

}
