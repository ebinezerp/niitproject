package ecommerce.database.daoImpl.products;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.database.dao.products.AirConditionerDaoService;
import ecommerce.database.model.products.AirConditioner;


@Component
@Transactional
public class AirConditionerDaoImpl implements AirConditionerDaoService {

	@Autowired
     private	SessionFactory sessionFactory;
	
	@Override
	public boolean addAirConditioner(AirConditioner airConditioner) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(airConditioner);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
		
	}

	@Override
	public boolean deleteAirConditioner(AirConditioner airConditioner) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(airConditioner);
			return true;
			
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean updateAirConditioner(AirConditioner airConditioner) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(airConditioner);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public AirConditioner retrieveAirConditionerById(long productId) {
		// TODO Auto-generated method stub
		try {
		return	(AirConditioner)sessionFactory.getCurrentSession().createQuery("from AirConditioner where productId=:id").setParameter("id",productId).getSingleResult();
			
		} catch (HibernateException e) {
			// TODO: handle exception
			return null;
		}
		
	}

	@Override
	public List<AirConditioner> getAllAirConditioners() {
		// TODO Auto-generated method stub
		try {
			return  sessionFactory.getCurrentSession().createCriteria(AirConditioner.class).list();
		} catch (HibernateException e) {
			// TODO: handle exception
			return null;
		}
	}

}
