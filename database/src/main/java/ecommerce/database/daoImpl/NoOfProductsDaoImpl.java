package ecommerce.database.daoImpl;

import java.util.List;

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

	@Override
	public List<NumberOfProducts> getNumberOfProducts(long productId) {
		// TODO Auto-generated method stub
		try {
	return		sessionFactory.getCurrentSession().createQuery("from NumberOfProducts where product_productId=:id and bought=false").setParameter("id",productId).list();
		} catch (HibernateException e) {
			// TODO: handle exception
		return  null;
		}
	}

	@Override
	public NumberOfProducts getNumberOfProductsByNoOfproductsId(long productNumber) {
		// TODO Auto-generated method stub
		try {
		return	(NumberOfProducts)sessionFactory.getCurrentSession().createQuery("from NumberOfProducts where productNumber=:id").setParameter("id",productNumber).getSingleResult();
		} catch (HibernateException e) {
			// TODO: handle exception
			return null;
		}
	}

}
