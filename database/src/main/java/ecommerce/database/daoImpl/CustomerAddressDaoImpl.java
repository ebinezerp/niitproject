package ecommerce.database.daoImpl;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.database.dao.CustomerAddressDaoService;
import ecommerce.database.model.CustomerAddress;

@Component
@Transactional
public class CustomerAddressDaoImpl implements CustomerAddressDaoService {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addCustomerAddress(CustomerAddress customerAddress) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(customerAddress);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean deleteCustomerAddress(CustomerAddress customerAddress) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(customerAddress);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public CustomerAddress getCustomerAddressById(long address_id) {
		// TODO Auto-generated method stub
	try {
	return	sessionFactory.getCurrentSession().get(CustomerAddress.class,address_id);
		
	} catch (HibernateException e) {
		// TODO: handle exception
        return  null;
	}
	}

}
