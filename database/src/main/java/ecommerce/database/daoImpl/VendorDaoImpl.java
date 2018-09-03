package ecommerce.database.daoImpl;

import javax.transaction.Transactional;

import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.database.dao.VendorDaoService;
import ecommerce.database.model.Vendor;

@Component
@Transactional
public class VendorDaoImpl implements VendorDaoService{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addVendor(Vendor vendor) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(vendor);
			
			return true;
		}catch(HibernateException e) {
			return false;
		}
	}

	@Override
	public boolean deleteVendor(Vendor vendor) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(vendor);
			return true;
		}catch(HibernateException e) {
			return false;
		}
	}

	@Override
	public boolean editVendor(Vendor vendor) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(vendor);
			return true;
		}catch(HibernateException e) {
			return false;
		}
		
		
	}

	@Override
	public Vendor getVendorById(long vendor_id) {
		// TODO Auto-generated method stub
		try {
		return (Vendor)sessionFactory.getCurrentSession().get(Vendor.class,vendor_id);
		
		} catch (HibernateException e) {
			// TODO: handle exception
			return null;
		}
		
	}

	@Override
	public Vendor getVendorByEmail(String vendor_email) {
		// TODO Auto-generated method stub
		try {
			return (Vendor)sessionFactory.getCurrentSession().createQuery("from Vendor where vendor_email=:email").setParameter("email", vendor_email).getSingleResult();
			
			
			} catch (HibernateException e) {
				// TODO: handle exception
				return null;
			}
		
	}
	
	@Override
	public Vendor vendorLogin(String vendor_email,String vendor_password) {
		
		try {
			System.out.println(vendor_email+" "+vendor_password);
		return sessionFactory.getCurrentSession().createQuery("from Vendor where vendor_email=:email and vendor_password=:password",Vendor.class).setParameter("email",vendor_email).setParameter("password", vendor_password).getSingleResult();
			
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	

}
