package ecommerce.database.daoImpl;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.database.dao.CustomerDaoService;
import ecommerce.database.model.Customer;

@Component
@Transactional
public class CustomerDaoImpl implements CustomerDaoService{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(customer);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean deleteCustomer(Customer customer) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(customer);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public Customer getCustomerById(long customer_id) {
		// TODO Auto-generated method stub
		try {
			return sessionFactory.getCurrentSession().get(Customer.class,customer_id);
		} catch (HibernateException e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public Customer getCustomerByEmail(String email) {
		// TODO Auto-generated method stub
		try {
			return (Customer)sessionFactory.getCurrentSession().createQuery("from Customer where customer_email=:email").setParameter("email", email).getSingleResult();
		} catch (HibernateException e) {
			// TODO: handle exception
			return null;
		}
	}

}
