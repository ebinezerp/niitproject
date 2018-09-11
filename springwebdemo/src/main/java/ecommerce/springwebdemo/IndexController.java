package ecommerce.springwebdemo;

import java.io.IOException;
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
import org.springframework.web.servlet.ModelAndView;

import ecommerce.database.dao.CategoryDaoService;
import ecommerce.database.dao.SubCategoryDaoService;
import ecommerce.database.dao.VendorDaoService;
import ecommerce.database.dao.admin.AdminDao;
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
	
	//@RequestMapping(value= {"/","index"},method=RequestMethod.GET)
	@GetMapping(value= {"/","index"})
	public ModelAndView indexPage()
	{
		ModelAndView view=new ModelAndView("index");
		view.addObject("message","Hello World");
		return view;
	}
	
	@RequestMapping("aboutus")
	public String aboutUs(Model model)
	{
		model.addAttribute("message", "Im Nikhil Chandra");
	    return "aboutus";
	}
	
	@GetMapping("signup")
	public ModelAndView signUp()
	{
		ModelAndView view=new ModelAndView("signup");
		view.addObject("vendor",new Vendor());
		return view;
	}
	
    @PostMapping("signup")
	public String addVendor(@Valid @ModelAttribute("vendor") Vendor vendor,BindingResult result,HttpServletRequest httpServletRequest)
	{
    	
    	if(!result.hasErrors())
    	{
    		Random randomCode=new Random();
        	int verify=randomCode.nextInt(99999) +  10000;
            vendor.setVerificationCode(verify);
    		if(vendorDaoService.addVendor(vendor))
        	{
        		System.out.println(vendor.getVendor_name());
                 mail=new Mail();
                mail.sendMail(vendor.getVendor_email(), vendor.getVendor_name(),verify);
              httpServletRequest.setAttribute("id", vendor.getVendor_id());
              System.out.println(vendor.getVendor_id());
           
        		return "emailConfirmation";
        	}else {
        		return "signup";
        	}
    		
    	}else {
    		return "signup";
    		
    	}
    	
         		
	}
    
    
    @PostMapping("emailverification")
    public String emailConfirmation(HttpServletRequest request)
    {
    	System.out.println(Integer.parseInt(request.getParameter("id")));
     Vendor	existingvendor=vendorDaoService.getVendorById(Integer.parseInt(request.getParameter("id")));
     System.out.println("from page"+request.getAttribute("code"));
     System.out.println("from database"+existingvendor.getVerificationCode());
           	if(Integer.parseInt(request.getParameter("code"))==existingvendor.getVerificationCode())
           	{
           		existingvendor.setEmailverified(true);
           		vendorDaoService.editVendor(existingvendor);
           		return "redirect:login";
           		
           	}else {
           		return "emailConfirmation";
           	}
    }
    
    
    
    
   
	@GetMapping("login")
	public ModelAndView login()
	{
		ModelAndView view = new ModelAndView("login");
		view.addObject("vendor", new Vendor());
		return view;
	}
	
	@PostMapping("login")
	public String vendorLogin(String email,String password,Model model,HttpSession httpSession)
	{
		
		//System.out.println(vendorDaoService.getVendorByEmail(vendor.getVendor_email()));
	Vendor	vendor=vendorDaoService.vendorLogin(email,password);
		if(vendor!=null)
		 {
			
			System.out.println("login Successful");
			httpSession.setAttribute("vendor", vendor);
			System.out.println(vendor);
			return "profile";
		 }else {
			 System.out.println("login Unsuccessful");
			 model.addAttribute("message","No Vendor exists with these credentials");
			 return "redirect:login";
		 }
	}
	
	@GetMapping("adminlogin")
	public String adminLogin(Model model)
	{
		model.addAttribute("admin", new Admin());
		return "adminlogin";
	}
	
	@PostMapping("adminlogin")
	public String adminLogin(@ModelAttribute("admin") Admin admin,Map<String, Object> vendor)
	{
	  	 admin=adminDao.adminLogin(admin.getEmail(), admin.getPassword());
	  	 if(admin!=null)
	  	 {
	  		return "redirect:/adminpage";
	  	 }else {
	  		 return "adminlogin";
	  	 }
	}
	
	@GetMapping("adminpage")
	public String adminPage(Model model){
		
		 model.addAttribute("vendorslist", adminDao.getVendors());
		return "adminpage";
		
	}
	
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
	
	
	
}
