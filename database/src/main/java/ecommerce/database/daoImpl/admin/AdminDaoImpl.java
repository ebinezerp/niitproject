package ecommerce.database.daoImpl.admin;

import java.util.List;
import java.util.Set;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import ecommerce.database.dao.admin.AdminDao;
import ecommerce.database.model.Vendor;
import ecommerce.database.model.admin.Admin;

@Component
@Transactional
public class AdminDaoImpl implements AdminDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		try {
			
			sessionFactory.getCurrentSession().save(admin);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
		
	}

	@Override
	public boolean deleteAdmin(Admin admin) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(admin);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
		
	}

	@Override
	public Admin adminLogin(String email,String password) {
		// TODO Auto-generated method stub
		try {
			return (Admin)sessionFactory.getCurrentSession().createQuery("from Admin where email=:email and password=:password").setParameter("email", email).setParameter("password", password).getSingleResult();
			
		} catch (HibernateException | NoResultException e) {
			// TODO: handle exception
			return null;
		}
		
	}

	@Override
	public List<Vendor> getVendors() {
		// TODO Auto-generated method stub
		try {
			
	  return sessionFactory.getCurrentSession().createQuery("from Vendor where vendor_active=false",Vendor.class).list();
		}catch (NullPointerException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

}
