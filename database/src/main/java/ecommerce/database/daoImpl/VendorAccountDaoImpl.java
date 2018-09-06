package ecommerce.database.daoImpl;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.database.dao.VendorAccountDaoService;
import ecommerce.database.model.VendorAccountDetails;

@Component
@Transactional
public class VendorAccountDaoImpl implements VendorAccountDaoService{
	
    @Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addVendorAccount(VendorAccountDetails accountDetails) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(accountDetails);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return true;
	}

	@Override
	public boolean editVendorAccount(VendorAccountDetails accountDetails) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(accountDetails);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean deleteVendorAccount(VendorAccountDetails accountDetails) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(accountDetails);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public VendorAccountDetails getVendorAccountById(long account_id) {
		// TODO Auto-generated method stub
		try {
			return sessionFactory.getCurrentSession().get(VendorAccountDetails.class, account_id);
			
		} catch (HibernateException e) {
			// TODO: handle exception
			return null;
		}
		
	}

	@Override
	public VendorAccountDetails getVendorAccountByAccountNumber(String account_number) {
		// TODO Auto-generated method stub
		return null;
	}

}
