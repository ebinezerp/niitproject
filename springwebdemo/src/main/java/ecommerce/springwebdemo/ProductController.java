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
	


	
	@GetMapping("/vendor/addproduct")
	public String addProductsPage(Model model) {
		List<SubCategory> subcategories = subCategoryDaoService.getAllSubcategories();
		model.addAttribute("subcategorieslist", subcategories);
		return "subcategory";
	}

	@PostMapping("/vendor/getproductmodel")
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
			model.addAttribute("earphones", new EarPhone());
			return "earphones";
		
		case "watch":
			model.addAttribute("watch", new Watch());
			return "watch";
	    
		case "ssd":
			model.addAttribute("ssd", new SSD());
			return "ssd";
	
		case "shoe":
			model.addAttribute("shoe", new Shoe());
			return "shoe";
		
		case "powerbank":
			model.addAttribute("powerbank", new PowerBank());
			return "powerbank";

		default:
			return "subcategory";
		}
	}

	

	@GetMapping("/vendor/editproductdetails/{productId}")
	public String editProductDetails(@PathVariable("productId")long productId,Model model,HttpServletRequest request)
	{	
		String name=subCategoryDaoService.getSubCategory(productDaoService.getSubCategoryId(productId)).getSubCategory_name();
		switch(name)
		{
		case "mobile":model.addAttribute("mobile",mobileDaoService.getMobile(productId));
			return "editmobile";
	
		               
		case "laptop": model.addAttribute("laptop",laptopDaoService.retrieveLaptopById(productId));
			return "editlaptop";
			
		case "refrigerator":model.addAttribute("refrigerator",refrigeratorDaoService.retrieveRefrigeratorById(productId));
		    return "editrefrigerator";
		  
		case "airconditioner":model.addAttribute("airconditioner",airConditionerDaoService.retrieveAirConditionerById(productId));
		    return "editairconditioner";
		
		case "television":model.addAttribute("television",televisionDaoService.retrieveTelevisionById(productId));
		    return "edittelevision";
		    
		case "earphones":model.addAttribute("earphones",earPhoneDaoService.retrieveEarPhoneById(productId));
		    return "editearphones";
		    
		case "powerbank":model.addAttribute("powerbank",powerBankDaoService.retrievePowerBankById(productId));
		    return "editpowerbank";
		
		case "shoe":model.addAttribute("shoe",shoeDaoService.retrieveShoesById(productId));
		    return "editshoe";
		    
		case "ssd":model.addAttribute("ssd",ssdDaoService.retrieveSSDById(productId));
		    return "editssd";
		    
		case "watch":model.addAttribute("watch",watchDaoService.retrieveWatchById(productId));
		    return "editwatch";
		
		default:return "products";
		}
				
	}	
	
	@GetMapping("/vendor/productdetails/{productId}")
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



	@GetMapping("/vendor/deleteproduct/{productId}")
	public String deleteProduct(@PathVariable("productId") long productId, HttpServletRequest request) {

		Product product = productDaoService.getProduct(productId);
		product.setDeleted(true);
		if (productDaoService.updateProduct(product)) {
			return "redirect:/vendor/products";
		} else {
			return "deleteproduct/{productId}";
		}

	}
	
	@GetMapping("displayproducts/{subCategory_name}")
	public String displayProducts(@PathVariable("subCategory_name")String subCategory_name,Model model)
	{
		switch (subCategory_name) {
		case "mobile":model.addAttribute("products",getSortedMobiles(mobileDaoService.getAllMobiles()));
		       return "displaySelectedProducts";	
		case "laptop":model.addAttribute("products",getSortedLaptops(laptopDaoService.getAllLaptops()));
		       return "displaySelectedProducts";
		case "television":model.addAttribute("products",getSortedTelevisions(televisionDaoService.getAllTelevisions()));
		       return "displaySelectedProducts";
		case "refrigerator":model.addAttribute("products",getSortedRefrigerators(refrigeratorDaoService.getAllRefrigerators()));
		       return "displaySelectedProducts";
		case "airconditioner":model.addAttribute("products",getSortedAirConditioners(airConditionerDaoService.getAllAirConditioners()));
		       return "displaySelectedProducts";
		case "earphones":model.addAttribute("products", getSortedEarPhones(earPhoneDaoService.getAllEarPhones()));
		       return "displaySelectedProducts";
		case "ssd":model.addAttribute("products",getSortedSSDs(ssdDaoService.getAllSSD()));
		       return "displaySelectedProducts";
		case "powerbank":model.addAttribute("products",getSortedPowerBanks(powerBankDaoService.getAllPowerBanks()));
		       return "displaySelectedProducts";
		case "watch":model.addAttribute("products", getSortedWatches(watchDaoService.getAllWatches()));
		       return "displaySelectedProducts";
		case "shoe":model.addAttribute("products",getSortedShoes(shoeDaoService.getAllShoes()));
		       return "displaySelectedProducts";
		default: return "index";
		
		}
	}
	
	
	public List<Mobile> getSortedMobiles(List<Mobile> mobiles)
	{
		List<Mobile> sorted=new ArrayList<Mobile>();
		for(Mobile mobile:mobiles)
		{
			if(mobile.isDeleted()==false)
			{
				sorted.add(mobile);
			}
		}
		return sorted;
	}
	
	
	public List<Laptop> getSortedLaptops(List<Laptop> laptops)
	{
		List<Laptop> sorted=new ArrayList<Laptop>();
		for(Laptop laptop:laptops)
		{
			if(laptop.isDeleted()==false)
			{
				sorted.add(laptop);
			}
		}
		return sorted;
	}
	
	public List<Refrigerator> getSortedRefrigerators(List<Refrigerator> refrigerators)
	{
		List<Refrigerator> sorted=new ArrayList<Refrigerator>();
		for(Refrigerator refrigerator:refrigerators)
		{
			if(refrigerator.isDeleted()==false)
			{
				sorted.add(refrigerator);
			}
		}
		return sorted;
	}
	
	public List<AirConditioner> getSortedAirConditioners(List<AirConditioner> airConditioners)
	{
		List<AirConditioner> sorted=new ArrayList<AirConditioner>();
		for(AirConditioner airconditioner:airConditioners)
		{
			if(airconditioner.isDeleted()==false)
			{
				sorted.add(airconditioner);
			}
		}
		return sorted;
	}
	
	public List<Watch> getSortedWatches(List<Watch> watches)
	{
		List<Watch> sorted=new ArrayList<Watch>();
		for(Watch watch:watches)
		{
			if(watch.isDeleted()==false)
			{
				sorted.add(watch);
			}
		}
		return sorted;
	}
	
	public List<Shoe> getSortedShoes(List<Shoe> shoes)
	{
		List<Shoe> sorted=new ArrayList<Shoe>();
		for(Shoe shoe:shoes)
		{
			if(shoe.isDeleted()==false)
			{
				sorted.add(shoe);
			}
		}
		return sorted;
	}
	
	public List<SSD> getSortedSSDs(List<SSD> ssds)
	{
		List<SSD> sorted=new ArrayList<SSD>();
		for(SSD ssd:ssds)
		{
			if(ssd.isDeleted()==false)
			{
				sorted.add(ssd);
			}
		}
		return sorted;
		
	}
	
	public List<PowerBank> getSortedPowerBanks(List<PowerBank> powerBanks)
	{
	  List<PowerBank> sorted=new ArrayList<PowerBank>();
	  for(PowerBank powerBank:powerBanks)
	  {
		  if(powerBank.isDeleted()==false)
		  {
			  sorted.add(powerBank);
		  }
	  }
	  return sorted;
	}
	
	
	public List<EarPhone> getSortedEarPhones(List<EarPhone> earphones)
	{
		List<EarPhone> sorted=new ArrayList<EarPhone>();
		for(EarPhone earphone:earphones)
		{
			if(earphone.isDeleted()==false)
			{
				sorted.add(earphone);
			}
		}
		return sorted;
	}
	
	public List<Television> getSortedTelevisions(List<Television> televisions)
	{
		List<Television> sorted=new ArrayList<Television>();
		for(Television television:televisions)
		{
			if(television.isDeleted()==false)
			{
				sorted.add(television);
			}
		}
		return sorted;
	}

}