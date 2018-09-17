package ecommerce.database.daoImpl.products;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.database.dao.products.PowerBankDaoService;
import ecommerce.database.model.products.PowerBank;

@Component
@Transactional
public class PowerBankDaoImpl implements PowerBankDaoService{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addPowerBank(PowerBank powerBank) {
		// TODO Auto-generated method stub
	try {
		sessionFactory.getCurrentSession().save(powerBank);
		return true;
	} catch (HibernateException e) {
		// TODO: handle exception
		return false;
	}
	}

	@Override
	public boolean deletePowerBank(PowerBank powerBank) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(powerBank);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean updatePowerBank(PowerBank powerBank) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(powerBank);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public PowerBank retrievePowerBankById(long productId) {
		// TODO Auto-generated method stub
		try {
		return (PowerBank)sessionFactory.getCurrentSession().createQuery("from PowerBank where productId=:id").setParameter("id",productId).getSingleResult();
		
		} catch (HibernateException e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public List<PowerBank> getAllPowerBanks() {
		// TODO Auto-generated method stub
		try {
		return 	sessionFactory.getCurrentSession().createCriteria(PowerBank.class).list();
		} catch (HibernateException e) {
			// TODO: handle exception
			return null;
		}
	}

}
