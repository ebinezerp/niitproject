package ecommerce.springwebdemo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ecommerce.database.dao.NoOfProductsDaoService;
import ecommerce.database.dao.SubCategoryDaoService;
import ecommerce.database.dao.products.MobileDaoService;
import ecommerce.database.model.NumberOfProducts;
import ecommerce.database.model.SubCategory;
import ecommerce.database.model.Vendor;
import ecommerce.database.model.products.Laptop;
import ecommerce.database.model.products.Mobile;
import ecommerce.database.model.products.Refrigerator;

@Controller
public class ProductController {

	@Autowired
    private SubCategoryDaoService subCategoryDaoService;
	
	@Autowired
	private MobileDaoService mobileDaoService;
	
	@Autowired
	private NoOfProductsDaoService noOfProductsDaoService;
	
	@Autowired
	private NumberOfProducts numberOfProducts;
	
	@GetMapping("addproduct")
	public String addProductsPage(Model model)
	{
	    List<SubCategory> subcategories=subCategoryDaoService.getAllSubcategories();
	    model.addAttribute("subcategorieslist",subcategories);
	    return "subcategory";
	}
	
	
	@PostMapping("getproductmodel")
	public String routeToSubcategories(HttpServletRequest request,Model model)
	{
		SubCategory subCategory=subCategoryDaoService.getSubCategory(Integer.parseInt(request.getParameter("subcategory")));
		model.addAttribute("subCategoryId",Integer.parseInt(request.getParameter("subcategory")));
		switch(subCategory.getSubCategory_name())
		{
		case "mobile":model.addAttribute("mobile",new Mobile());
			return "mobile";
		case "laptop":model.addAttribute("laptop" , new Laptop());
			return "laptop";
		case "refrigerator":model.addAttribute("refrigerator", new Refrigerator());
		return "refrigerator";
		default :return "subcategory";
		}
	}
	
	@PostMapping("addmobile")
	public String addMobile(@ModelAttribute("mobile") Mobile mobile,HttpSession session)
	{
		mobile.setVendor((Vendor)session.getAttribute("vendor"));
		if(mobileDaoService.addMobile(mobile))
		{
			numberOfProducts.setProduct(mobile);
			for(int i=0;i<mobile.getNoOfProducts();i++) {
				
			    if(noOfProductsDaoService.addNumberOFProducts(numberOfProducts)==false)
			    {
			    	System.out.println("adding Number of products failed");
				    return "addproduct";
			    }
			}
			
			System.out.println("Number of Products Successfully added");
			
			return "products";
			
		}else {
			return "addproduct";
		}
	}
	
}
