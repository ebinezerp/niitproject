package ecommerce.database.dao;

import java.util.List;

import ecommerce.database.model.NumberOfProducts;

public interface NoOfProductsDaoService {
	
	public abstract boolean addNumberOFProducts(NumberOfProducts numberOfProducts);
    public abstract List<NumberOfProducts> getNumberOfProducts(long productId);
    public abstract NumberOfProducts getNumberOfProductsByNoOfproductsId(long productNumber);
}
