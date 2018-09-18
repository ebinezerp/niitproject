package ecommerce.database.daoImpl.products;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.database.dao.products.WatchDaoService;
import ecommerce.database.model.products.Watch;

@Component
@Transactional
public class WatchDaoImpl implements WatchDaoService{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addWatch(Watch watch) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(watch);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean deleteWatch(Watch watch) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(watch);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean updateWatch(Watch watch) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(watch);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public Watch retrieveWatchById(long productId) {
		// TODO Auto-generated method stub
		try {
		return	(Watch)sessionFactory.getCurrentSession().createQuery("from Watch where productId=:id").setParameter("id",productId).getSingleResult();
			
		} catch (HibernateException e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public List<Watch> getAllWatches() {
		// TODO Auto-generated method stub
		try {
		return 	sessionFactory.getCurrentSession().createCriteria(Watch.class).list();
		} catch (HibernateException e) {
			// TODO: handle exception
			return null;
		}
	}

}
