package ecommerce.database.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.database.dao.SubCategoryDaoService;
import ecommerce.database.model.Product;
import ecommerce.database.model.SubCategory;


@Component
@Transactional
public class SubCategoryDaoImpl implements SubCategoryDaoService{

	    @Autowired
		private SessionFactory sessionFactory;
	
	@Override
	public SubCategory getSubCategory(int subCategory_id) {
		// TODO Auto-generated method stub
		try {
			
		return	(SubCategory)sessionFactory.getCurrentSession().createQuery("from SubCategory where subCategory_id=:id").setParameter("id",subCategory_id).getSingleResult();
			
			
		} catch (HibernateException e) {
			// TODO: handle exception
			return null;
		}

	}
	
	

	@Override
	public List<SubCategory> getAllSubcategories() {
		// TODO Auto-generated method stub
		try {
			
			return	sessionFactory.getCurrentSession().createCriteria(SubCategory.class).list();
				
				
			} catch (HibernateException e) {
				// TODO: handle exception
				return null;
			}

	}



	@Override
	public List<Product> getProductsBySubCategoryId(int subCategory_id) {
		// TODO Auto-generated method stub
		try {
		
			return sessionFactory.getCurrentSession().createQuery("from Product where subCategory_subCategory_id=:id",Product.class).setParameter("id",subCategory_id).list();
		}catch (HibernateException e) {
			// TODO: handle exception
			return null;
		}
		
		
	}



	@Override
	public List<SubCategory> getSubCategoriesOfElectronics() {
		// TODO Auto-generated method stub
		try {
		return	sessionFactory.getCurrentSession().createQuery("from SubCategory where category_category_id=1").list();
		} catch (HibernateException e) {
			// TODO: handle exception
			return null;
		}
	}



	@Override
	public List<SubCategory> getSubCategoriesOfHomeAppliances() {
		// TODO Auto-generated method stub
		try {
			return	sessionFactory.getCurrentSession().createQuery("from SubCategory where category_category_id=2").list();
			} catch (HibernateException e) {
				// TODO: handle exception
				return null;
			}
	}



	@Override
	public List<SubCategory> getSubCatgoriesOfAccessories() {
		// TODO Auto-generated method stub
		try {
			return	sessionFactory.getCurrentSession().createQuery("from SubCategory where category_category_id=3").list();
			} catch (HibernateException e) {
				// TODO: handle exception
				return null;
			}
	}



	@Override
	public List<SubCategory> getSubCategoriesOFFashion() {
		// TODO Auto-generated method stub
		try {
			return	sessionFactory.getCurrentSession().createQuery("from SubCategory where category_category_id=4").list();
			} catch (HibernateException e) {
				// TODO: handle exception
				return null;
			}
	}
}


