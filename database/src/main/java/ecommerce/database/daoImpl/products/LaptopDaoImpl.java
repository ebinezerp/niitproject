package ecommerce.database.daoImpl.products;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.database.dao.products.LaptopDaoService;
import ecommerce.database.model.products.Laptop;

@Component
@Transactional
public class LaptopDaoImpl implements LaptopDaoService{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addLaptop(Laptop laptop) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(laptop);
			return true;			
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
		
	}

	@Override
	public boolean deleteLaptop(Laptop laptop) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(laptop);
			return true;			
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean updateLaptop(Laptop laptop) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(laptop);
			return true;			
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public Laptop retrieveLaptopById(long laptop_id) {
		// TODO Auto-generated method stub
		
				return null;
	}

}
