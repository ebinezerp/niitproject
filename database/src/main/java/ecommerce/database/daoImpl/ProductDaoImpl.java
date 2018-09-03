package ecommerce.database.daoImpl;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.database.dao.ProductDaoService;
import ecommerce.database.model.Product;

@Component
@Transactional
public class ProductDaoImpl implements ProductDaoService{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(product);
			return true;			
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
		
	}

	@Override
	public boolean deleteProduct(Product product) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(product);
			return true;			
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;			
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}

	}

}
