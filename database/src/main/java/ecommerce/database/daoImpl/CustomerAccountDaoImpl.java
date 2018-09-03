package ecommerce.database.daoImpl;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.database.dao.CustomerAccountDaoService;
import ecommerce.database.model.CustomerAccount;

@Component
@Transactional
public class CustomerAccountDaoImpl implements CustomerAccountDaoService{

	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public boolean addCustomerAccount(CustomerAccount customerAccount) {
		// TODO Auto-generated method stub
		try {
			sessionfactory.getCurrentSession().save(customerAccount);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean deleteCustomerAccount(CustomerAccount customerAccount) {
		// TODO Auto-generated method stub
		try {
			sessionfactory.getCurrentSession().delete(customerAccount);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public CustomerAccount getCustomerAccountById(long account_id) {
		// TODO Auto-generated method stub
		try {
		return	sessionfactory.getCurrentSession().get(CustomerAccount.class,account_id);
		} catch (HibernateException e) {
			// TODO: handle exception
		return null;
		}
	}

}
