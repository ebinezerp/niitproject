package ecommerce.database.daoImpl.products;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.database.dao.products.EarPhoneDaoService;
import ecommerce.database.model.products.EarPhone;

@Component
@Transactional
public class EarPhoneDaoImpl implements EarPhoneDaoService{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addEarPhone(EarPhone earPhone) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(earPhone);
	return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			
			return false;	
		}
		
	}

	@Override
	public boolean deleteEarPhone(EarPhone earPhone) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(earPhone);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean updateEarPhone(EarPhone earPhone) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(earPhone);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public EarPhone retrieveEarPhoneById(long productId) {
		// TODO Auto-generated method stub

		try {
			return	(EarPhone)sessionFactory.getCurrentSession().createQuery("from EarPhone where productId=:id").setParameter("id",productId).getSingleResult();
			
		} catch (HibernateException e) {
			// TODO: handle exception
			return null;
		}
		
	}

	@Override
	public List<EarPhone> getAllEarPhones() {
		// TODO Auto-generated method stub
		try {
		return	sessionFactory.getCurrentSession().createCriteria(EarPhone.class).list();
		} catch (HibernateException e) {
			// TODO: handle exception
			return null;
		}
		
	}

}
