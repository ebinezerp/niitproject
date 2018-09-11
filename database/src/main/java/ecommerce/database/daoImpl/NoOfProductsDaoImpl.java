package ecommerce.database.daoImpl;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.database.dao.NoOfProductsDaoService;
import ecommerce.database.model.NumberOfProducts;

@Component
@Transactional
public class NoOfProductsDaoImpl implements NoOfProductsDaoService{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addNumberOFProducts(NumberOfProducts numberOfProducts) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(numberOfProducts);
			return true;
		}catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
		
	}

}
