package ecommerce.springwebdemo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ecommerce.database.dao.NoOfProductsDaoService;
import ecommerce.database.dao.ProductDaoService;
import ecommerce.database.dao.SubCategoryDaoService;
import ecommerce.database.dao.products.LaptopDaoService;
import ecommerce.database.dao.products.MobileDaoService;
import ecommerce.database.model.NumberOfProducts;
import ecommerce.database.model.Product;
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
	
	@Autowired
	private LaptopDaoService laptopDaoService;
	
	@Autowired
	private ProductDaoService productDaoService;
	
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
		
		List<NumberOfProducts> numberOfProductsList=listOfProducts(mobile);
		
		mobile.setNumberOfProducts(numberOfProductsList);
		
		if(mobileDaoService.addMobile(mobile))
		{	
			session.setAttribute("products",productDaoService.getAllProducts((Vendor)session.getAttribute("vendor")));
			return "redirect:products";
			
		}else {
			return "addproduct";
		}
	}
	
	
	@GetMapping("products")
	public String displayProducts(HttpSession session)
	{
		session.setAttribute("products",productDaoService.getAllProducts((Vendor)session.getAttribute("vendor")));
		return "products";
	}
	
	
	@GetMapping("productdetails/{productId}")
	public String getProductDetails(@PathVariable("productId")long productId,Model model)
	{
		System.out.println(productId);
		
		String name=subCategoryDaoService.getSubCategory(productDaoService.getSubCategoryId(productId)).getSubCategory_name();
		switch(name)
		{
		case "mobile":model.addAttribute("mobile",mobileDaoService.getMobile(productId));
			return "displaymobile";
		               
		case "laptop": model.addAttribute("laptop",laptopDaoService.retrieveLaptopById(productId));
			return "displaylaptop";
		default:return "products";
		}
				
	}
	

	
	@PostMapping("addlaptop")
	public String addLaptop(@ModelAttribute("laptop") Laptop laptop,HttpSession session)
	{
		laptop.setVendor((Vendor)session.getAttribute("vendor"));
		
		List<NumberOfProducts> numberOfProductsList=listOfProducts(laptop);
		
		laptop.setNumberOfProducts(numberOfProductsList);
		
		
		if(laptopDaoService.addLaptop(laptop))
		{			
			session.setAttribute("products",productDaoService.getAllProducts((Vendor)session.getAttribute("vendor")));
			return "redirect:products";
			
		}else {
			return "addproduct";
		}
	}
	
	
	private List<NumberOfProducts> listOfProducts(Product product)
	{
		List<NumberOfProducts> numberOfProductsList=new ArrayList<NumberOfProducts>();
		for(int i=1;i<=product.getNoOfProducts();i++)
		{
			NumberOfProducts numberOfProducts=new NumberOfProducts();
			numberOfProducts.setProduct(product);
			numberOfProductsList.add(numberOfProducts);
		}	
		return numberOfProductsList;
	}
	
}
