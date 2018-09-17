package ecommerce.database.daoImpl.products;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.database.dao.products.TelevisionDaoService;
import ecommerce.database.model.products.Television;

@Component
@Transactional
public class TelevisionDaoImpl implements TelevisionDaoService {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addTelevision(Television television) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(television);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
		
	}

	@Override
	public boolean deleteTelevision(Television television) {
		// TODO Auto-generated method stub
		
		try {
			sessionFactory.getCurrentSession().delete(television);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
		
		
	}

	@Override
	public boolean updateTelevision(Television television) {
		// TODO Auto-generated method stub
		
		try {
			sessionFactory.getCurrentSession().update(television);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
		
		
	}

	@Override
	public Television retrieveTelevisionById(long productId) {
		// TODO Auto-generated method stub
		try {
		return	(Television)sessionFactory.getCurrentSession().createQuery("from Television where productId=:id").setParameter("id",productId).getSingleResult();
		
			
		} catch (HibernateException e) {
			// TODO: handle exception
			return null;
		}
		
	}

	@Override
	public List<Television> getAllTelevisions() {
		// TODO Auto-generated method stub
		try {
	return		sessionFactory.getCurrentSession().createCriteria(Television.class).list();
		} catch (HibernateException e) {
			// TODO: handle exception
			return null;	
		}
		
	}

}
