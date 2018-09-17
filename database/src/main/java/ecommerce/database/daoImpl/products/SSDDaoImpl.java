package ecommerce.database.daoImpl.products;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.database.dao.products.SSDDaoService;
import ecommerce.database.model.products.SSD;

@Component
@Transactional
public class SSDDaoImpl implements SSDDaoService {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addSSD(SSD ssd) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(ssd);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean deleteSSD(SSD ssd) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(ssd);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean updateSSD(SSD ssd) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(ssd);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public SSD retrieveSSDById(long productId) {
		// TODO Auto-generated method stub
		try {
		return	(SSD)sessionFactory.getCurrentSession().createQuery("from SSD where productId=:id").setParameter("id",productId).getSingleResult();
		} catch (HibernateException e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public List<SSD> getAllSSD() {
		// TODO Auto-generated method stub
		try {
		return	sessionFactory.getCurrentSession().createCriteria(SSD.class).list();
		} catch (HibernateException e) {
			// TODO: handle exception
			return null;
		}
	}

}
