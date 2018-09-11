package ecommerce.database.dao;

import java.util.List;

import ecommerce.database.model.SubCategory;

public interface SubCategoryDaoService {
	
	public abstract SubCategory getSubCategory(int subCategory_id);
	public abstract List<SubCategory> getAllSubcategories();

}
