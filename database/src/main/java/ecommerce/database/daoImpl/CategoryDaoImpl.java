package ecommerce.database.daoImpl;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.database.dao.CategoryDaoService;
import ecommerce.database.model.Category;

@Component
@Transactional
public class CategoryDaoImpl implements CategoryDaoService{

    @Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addCategory(Category category) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(category);
			return true;			
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
		
	}

}
