package ecommerce.database.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.database.dao.ProductDaoService;
import ecommerce.database.model.Product;
import ecommerce.database.model.SubCategory;
import ecommerce.database.model.Vendor;

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

	@Override
	public List<Product> getAllProducts(Vendor vendor) {
		// TODO Auto-generated method stub
		try {
         return sessionFactory.getCurrentSession().createQuery("from Product where vendor_vendor_id=:id and deleted=false").setParameter("id", vendor.getVendor_id()).list();
		}catch (HibernateException e) {
			// TODO: handle exception
			return null;
		}
	
	}

	@Override
	public int getSubCategoryId(long productId) {
		// TODO Auto-generated method stub
		try {
  Product product= (Product)sessionFactory.getCurrentSession().createQuery("from Product where productId=:id").setParameter("id",productId).getSingleResult();
		
		return product.getSubCategory().getSubCategory_id();
		}catch (HibernateException e) {
			// TODO: handle exception
			return 0;
		}
		
	}



	@Override
	public Product getProduct(long productId) {
		// TODO Auto-generated method stub
		
		try {
		return (Product)sessionFactory.getCurrentSession().createQuery("from Product where productId=:id").setParameter("id",productId).getSingleResult();
		}catch (HibernateException e) {
			// TODO: handle exception
			return null;
		}
		
		
	}

	@Override
	public List<Product> getLastTenProducts() {
		// TODO Auto-generated method stub
		try {
			return sessionFactory.getCurrentSession().createQuery("from Product where deleted=false order by productId DESC ").setMaxResults(10).list();
		}catch (HibernateException e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
	

}
