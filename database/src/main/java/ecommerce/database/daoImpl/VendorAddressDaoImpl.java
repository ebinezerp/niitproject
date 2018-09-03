package ecommerce.database.daoImpl;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.database.dao.VendorAddressDaoService;
import ecommerce.database.model.VendorAddress;

@Component
@Transactional
public class VendorAddressDaoImpl implements VendorAddressDaoService{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addVendorAddress(VendorAddress address) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(address);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	
	}

	@Override
	public boolean deleteVendorAddress(VendorAddress address) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(address);
			return true;
			
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
		
	}

	@Override
	public boolean editVendorAddress(VendorAddress address) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(address);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
		
	}

	@Override
	public VendorAddress getVendorAddress(long address_id) {
		// TODO Auto-generated method stub
		try {
			return sessionFactory.getCurrentSession().get(VendorAddress.class,address_id);
		} catch (HibernateException e) {
			// TODO: handle exception
			return null;
		}
		
	}

}
