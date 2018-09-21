package ecommerce.springwebdemo;

import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ecommerce.database.dao.CategoryDaoService;
import ecommerce.database.dao.ProductDaoService;
import ecommerce.database.dao.SubCategoryDaoService;
import ecommerce.database.dao.VendorDaoService;
import ecommerce.database.dao.admin.AdminDao;
import ecommerce.database.dao.products.MobileDaoService;
import ecommerce.database.model.Product;
import ecommerce.database.model.SubCategory;
import ecommerce.database.model.Vendor;
import ecommerce.database.model.admin.Admin;
import ecommerce.database.model.products.Laptop;
import ecommerce.database.model.products.Mobile;
import ecommerce.database.model.products.Refrigerator;

@Controller
public class IndexController {
	
	@Autowired
	private VendorDaoService vendorDaoService;
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private Mail mail;
	
	@Autowired
	private SubCategoryDaoService subCategoryDaoService;
	
	@Autowired
	private ProductDaoService productDaoService;
	
	@Autowired
	private MobileDaoService mobileDaoService;
	

	@GetMapping(value= {"index"})
	public ModelAndView indexPage(HttpSession session)
	{
		List<Product> tenproducts=productDaoService.getLastTenProducts();
		System.out.println(tenproducts);
		session.setAttribute("tenproducts",tenproducts);
		session.setAttribute("electronics",subCategoryDaoService.getAllSubcategories());
		
		ModelAndView view=new ModelAndView("index");
		
		return view;
	}
	
	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public ModelAndView defaultPage() {

	  ModelAndView model = new ModelAndView();
	  model.addObject("title", "Spring Security Login Form - Database Authentication");
	  model.addObject("message", "This is default page!");
	  model.setViewName("hello");
	  return model;

	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView adminPage() {

	  ModelAndView model = new ModelAndView();
	  model.addObject("title", "Spring Security Login Form - Database Authentication");
	  model.addObject("message", "This page is for ROLE_ADMIN only!");
	  model.setViewName("admin");
	  return model;

	}
	
	@RequestMapping("aboutus")
	public String aboutUs(Model model)
	{
		model.addAttribute("message", "Im Nikhil Chandra");
	    return "aboutus";
	}
	
	
	
	@GetMapping("displayproducts/{subCategory_name}")
	public String displayProducts(@PathVariable("subCategory_name")String subCategory_name,HttpSession session)
	{
		switch (subCategory_name) {
		case "allmobiles":session.setAttribute("mobiles",getSortedMobiles(mobileDaoService.getAllMobiles()));
		       return "displayAllMobiles";	

		default: return "index";
		
		}
	}
	
   
    
    
  /*  
   
	@GetMapping("vendorlogin")
	public ModelAndView login()
	{
		ModelAndView view = new ModelAndView("vendorlogin");
		view.addObject("vendor", new Vendor());
		return view;
	}*/
	
	/*
	@PostMapping("vendorlogin")
	public String vendorLogin(Principal principal)
	{		
		productDaoService.getAllProducts(vendorDaoService.getVendorByEmail(principal.getName()));
		
		
		
		//System.out.println(vendorDaoService.getVendorByEmail(vendor.getVendor_email()));
	Vendor	vendor=vendorDaoService.vendorLogin(email,password);
		if(vendor!=null)
		 {
			
			System.out.println("login Successful");
			httpSession.setAttribute("vendor", vendor);
			System.out.println(vendor);
			return "redirect:/products";
		 }else {
			 System.out.println("login Unsuccessful");
			 model.addAttribute("message","No Vendor exists with these credentials");
			 return "redirect:login";
		 }
	}*/
	
	
    @RequestMapping(value = "/login",method=RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error",required = false) String error,@RequestParam(value = "logout",required=false)String logout)
    {
    	
    	ModelAndView model=new ModelAndView();
    	if(error!=null)
    	{
    		model.addObject("error","Invalid email and password");
    	}
    	
    	if(logout!=null)
    	{
    		model.addObject("msg","You've been logged out successfully");
    	}
    	model.setViewName("login");
    	return model;
    }
    
    
    
    
	@GetMapping("profile")
	public String displayProfile()
	{
		return "profile";
	}
	
	/*@GetMapping("adminlogin")
	public String adminLogin(Model model)
	{
		model.addAttribute("admin", new Admin());
		return "adminlogin";
	}*/
	
	
	
	@GetMapping("accept/{vendor_id}")
	public String acceptVendor(@PathVariable("vendor_id")int vendor_id)
	{
		Vendor vendor = vendorDaoService.getVendorById(vendor_id);
		vendor.setVendor_active(true);
		vendorDaoService.editVendor(vendor);
		return "redirect:/adminpage";
	}
	
	@GetMapping("reject/{vendor_id}")
	public String rejectVendor(@PathVariable("vendor_id")int vendor_id)
	{
		Vendor vendor=vendorDaoService.getVendorById(vendor_id);
		vendor.setVendor_active(false);
		vendorDaoService.editVendor(vendor);
		return "redirect:/adminpage";		
	}
	
	
	@GetMapping("editvendor")
	public String editVendor(Model model,HttpSession httpSession)
	{
		model.addAttribute("vendor",httpSession.getAttribute("vendor"));
	    	return "editvendor";
	}
	
	@PostMapping("editvendor")
	public String updateVendor(@ModelAttribute("vendor") Vendor vendor,HttpSession httpSession)
	{
		
		vendorDaoService.editVendor(vendor);
		System.out.println(vendor);
		httpSession.setAttribute("vendor", vendor);
		return "profile";
	}
	
	public List<Mobile> getSortedMobiles(List<Mobile> mobiles)
	{
		List<Mobile> sorted=null;
		
		for(Mobile mobile:mobiles)
		{
			if(mobile.isDeleted()==false)
			{
				sorted.add(mobile);
			}
		}
		return sorted;
		
	}
	
	
}
