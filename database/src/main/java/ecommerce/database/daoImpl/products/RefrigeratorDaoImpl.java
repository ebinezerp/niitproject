package ecommerce.database.daoImpl.products;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.database.dao.products.RefrigeratorDaoService;
import ecommerce.database.model.products.Refrigerator;

@Component
@Transactional
public class RefrigeratorDaoImpl implements RefrigeratorDaoService {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addRefrigerator(Refrigerator refrigerator) {
		// TODO Auto-generated method stub
		try {			
			sessionFactory.getCurrentSession().save(refrigerator);
			return true;			
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;	
		}
		
	}

	@Override
	public boolean updateRefrigerator(Refrigerator refrigerator) {
		// TODO Auto-generated method stub
		
		try {
			sessionFactory.getCurrentSession().update(refrigerator);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
		
		
	}

	@Override
	public boolean deleteRefrigerator(Refrigerator refrigerator) {
		// TODO Auto-generated method stub
		
		try {
			sessionFactory.getCurrentSession().delete(refrigerator);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
		
	}

	@Override
	public Refrigerator retrieveRefrigeratorById(long productId) {
		// TODO Auto-generated method stub
		
		try {
		return	(Refrigerator)sessionFactory.getCurrentSession().createQuery("from Refrigerator where productId=:id").setParameter("id",productId).getSingleResult();
			
			
		} catch (HibernateException e) {
			// TODO: handle exception
			return null;
		}
		
		
	}

	@Override
	public List<Refrigerator> getAllRefrigerators() {
		// TODO Auto-generated method stub
		
		try {
		return	sessionFactory.getCurrentSession().createCriteria(Refrigerator.class).list();
		} catch (HibernateException e) {
			// TODO: handle exception
		
		return null;
	    }
	}

}
