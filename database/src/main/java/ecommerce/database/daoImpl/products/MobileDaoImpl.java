package ecommerce.database.daoImpl.products;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.database.dao.products.MobileDaoService;
import ecommerce.database.model.products.Mobile;

@Component
@Transactional
public class MobileDaoImpl implements MobileDaoService {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addMobile(Mobile mobile) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(mobile);
			return true;			
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
		
	}

	@Override
	public boolean deleteMobile(Mobile mobile) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(mobile);
			return true;			
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean updateMobile(Mobile mobile) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(mobile);
			return true;			
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public Mobile getMobile(long productId) {
		// TODO Auto-generated method stub
		try {
		return  (Mobile)sessionFactory.getCurrentSession().createQuery("from Mobile where productId=:id").setParameter("id",productId).getSingleResult();
		}catch (HibernateException e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public List<Mobile> getAllMobiles() {
		// TODO Auto-generated method stub
		try {
			return sessionFactory.getCurrentSession().createCriteria(Mobile.class).list();
			
		}catch (HibernateException e) {
			// TODO: handle exception
			return null;
		}
	
		
	}

}
