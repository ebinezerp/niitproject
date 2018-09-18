package ecommerce.springwebdemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ContextPathCompositeHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ecommerce.database.dao.NoOfProductsDaoService;
import ecommerce.database.dao.ProductDaoService;
import ecommerce.database.dao.SubCategoryDaoService;
import ecommerce.database.dao.VendorDaoService;
import ecommerce.database.dao.products.AirConditionerDaoService;
import ecommerce.database.dao.products.EarPhoneDaoService;
import ecommerce.database.dao.products.LaptopDaoService;
import ecommerce.database.dao.products.MobileDaoService;
import ecommerce.database.dao.products.PowerBankDaoService;
import ecommerce.database.dao.products.RefrigeratorDaoService;
import ecommerce.database.dao.products.SSDDaoService;
import ecommerce.database.dao.products.ShoeDaoService;
import ecommerce.database.dao.products.TelevisionDaoService;
import ecommerce.database.dao.products.WatchDaoService;
import ecommerce.database.model.NumberOfProducts;
import ecommerce.database.model.Product;
import ecommerce.database.model.SubCategory;
import ecommerce.database.model.Vendor;
import ecommerce.database.model.products.AirConditioner;
import ecommerce.database.model.products.EarPhone;
import ecommerce.database.model.products.Laptop;
import ecommerce.database.model.products.Mobile;
import ecommerce.database.model.products.PowerBank;
import ecommerce.database.model.products.Refrigerator;
import ecommerce.database.model.products.SSD;
import ecommerce.database.model.products.Shoe;
import ecommerce.database.model.products.Television;
import ecommerce.database.model.products.Watch;

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

	@Autowired
	private RefrigeratorDaoService refrigeratorDaoService;

	@Autowired
	private AirConditionerDaoService airConditionerDaoService;

	@Autowired
	private VendorDaoService vendorDaoService;
	
	@Autowired
	private TelevisionDaoService televisionDaoService;

	@Autowired
	private EarPhoneDaoService earPhoneDaoService;
	
	@Autowired
	private PowerBankDaoService powerBankDaoService;
	
	@Autowired
	private ShoeDaoService shoeDaoService;
	
	@Autowired
	private SSDDaoService ssdDaoService;
	
	@Autowired
	private WatchDaoService watchDaoService;
	
	@Autowired
	private SaveImage saveImage;
	


	
	@GetMapping("addproduct")
	public String addProductsPage(Model model) {
		List<SubCategory> subcategories = subCategoryDaoService.getAllSubcategories();
		model.addAttribute("subcategorieslist", subcategories);
		return "subcategory";
	}

	@PostMapping("getproductmodel")
	public String routeToSubcategories(HttpServletRequest request, Model model) {
		SubCategory subCategory = subCategoryDaoService
				.getSubCategory(Integer.parseInt(request.getParameter("subcategory")));
		model.addAttribute("subCategoryId", Integer.parseInt(request.getParameter("subcategory")));
		switch (subCategory.getSubCategory_name()) {
		case "mobile":
			model.addAttribute("mobile", new Mobile());
			return "mobile";
		case "laptop":
			model.addAttribute("laptop", new Laptop());
			return "laptop";
		case "refrigerator":
			model.addAttribute("refrigerator", new Refrigerator());
			return "refrigerator";

		case "airconditioner":
			model.addAttribute("airconditioner", new AirConditioner());
			return "airconditioner";

		case "television":
			model.addAttribute("television", new Television());
			return "television";
			
		case "earphones":
			model.addAttribute("television", new EarPhone());
			return "television";
		
		case "watch":
			model.addAttribute("television", new Watch());
			return "television";
	    
		case "ssd":
			model.addAttribute("television", new SSD());
			return "television";
	
		case "shoe":
			model.addAttribute("television", new Shoe());
			return "television";
		
		case "powerbank":
			model.addAttribute("television", new PowerBank());
			return "television";

		default:
			return "subcategory";
		}
	}

	@GetMapping(value= {"products","vendorlogin"})
	public String displayProducts(HttpSession session,Principal principal) {
		session.setAttribute("products", productDaoService.getAllProducts(vendorDaoService.getVendorByEmail(principal.getName())));
		session.setAttribute("vendor",vendorDaoService.getVendorByEmail(principal.getName()));
		return "products";
	}

	@GetMapping("productdetails/{productId}")
	public String getProductDetails(@PathVariable("productId")long productId,Model model,HttpServletRequest request)
	{
		String path=request.getContextPath();
		System.out.println(productId);
		
		String name=subCategoryDaoService.getSubCategory(productDaoService.getSubCategoryId(productId)).getSubCategory_name();
		model.addAttribute("name",name);
		switch(name)
		{
		case "mobile":model.addAttribute("mobile",mobileDaoService.getMobile(productId));
			return "displaymobile";
	
		               
		case "laptop": model.addAttribute("laptop",laptopDaoService.retrieveLaptopById(productId));
			return "displaylaptop";
			
		case "refrigerator":model.addAttribute("refrigerator",refrigeratorDaoService.retrieveRefrigeratorById(productId));
		    return "displayrefrigerator";
		  
		case "airconditioner":model.addAttribute("airconditioner",airConditionerDaoService.retrieveAirConditionerById(productId));
		    return "displayairconditioner";
		
		case "television":model.addAttribute("television",televisionDaoService.retrieveTelevisionById(productId));
		    return "displaytelevision";
		    
		case "earphones":model.addAttribute("earphones",earPhoneDaoService.retrieveEarPhoneById(productId));
		    return "displayearphones";
		    
		case "powerbank":model.addAttribute("powerbank",powerBankDaoService.retrievePowerBankById(productId));
		    return "displaypowerbank";
		
		case "shoe":model.addAttribute("shoe",shoeDaoService.retrieveShoesById(productId));
		    return "displayshoe";
		    
		case "ssd":model.addAttribute("ssd",ssdDaoService.retrieveSSDById(productId));
		    return "displayssd";
		    
		case "watch":model.addAttribute("watch",watchDaoService.retrieveWatchById(productId));
		    return "displaywatch";
		
		default:return "products";
		}
				
	}	



	@GetMapping("deleteproduct/{productId}")
	public String deleteProduct(@PathVariable("productId") long productId, HttpServletRequest request) {

		Product product = productDaoService.getProduct(productId);
		product.setDeleted(true);
		if (productDaoService.updateProduct(product)) {
			return "redirect:/products";
		} else {
			return "deleteproduct/{productId}";
		}

	}
}
