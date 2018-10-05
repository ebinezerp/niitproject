package ecommerce.springwebdemo;

import java.security.Principal;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ecommerce.database.dao.ProductDaoService;
import ecommerce.database.dao.VendorDaoService;
import ecommerce.database.dao.cart.CartDaoService;
import ecommerce.database.model.Vendor;


@Controller
public class VendorController {
	
	@Autowired
	private VendorDaoService vendorDaoService;
	
	@Autowired
	private Mail mail;
	
	@Autowired
	private ProductDaoService productDaoService;
	
	@GetMapping("vendorsignup")
	public ModelAndView signUp()
	{
		ModelAndView view=new ModelAndView("vendorsignup");
		view.addObject("vendor",new Vendor());
		return view;
	}
	
	 @PostMapping("vendorsignup")
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
	        		return "vendorsignup";
	        	}
	    		
	    	}else {
	    		return "vendorsignup";
	    		
	    	}
	    	
	         		
		}
	 
	 @GetMapping(value= {"/vendor/products"})
		public String displayProducts(HttpSession session,Principal principal) {
		  
		 String email=principal.getName();
		 Vendor vendor=vendorDaoService.getVendorByEmail(email);
			
				session.setAttribute("products",  productDaoService.getAllProducts(vendor));	
				session.setAttribute("vendor",vendorDaoService.getVendorByEmail(principal.getName()));
				return "products";							
		}
	    
	 @GetMapping("vendorlogin")
	 public String vendorLoginPage()
	 {
		 return "vendorlogin";
	 }
	 
	    
	    @PostMapping("emailverification")
	    public String emailConfirmation(HttpServletRequest request)
	    {
	    	
	     Vendor	existingvendor=vendorDaoService.getVendorById(Integer.parseInt(request.getParameter("id")));
	           	if(Integer.parseInt(request.getParameter("code"))==existingvendor.getVerificationCode())
	           	{
	           		existingvendor.setEmailverified(true);
	           		vendorDaoService.editVendor(existingvendor);
	           		return "redirect:login";
	           		
	           	}else {
	           		return "emailConfirmation";
	           	}
	    }
	    
	    
	   
	    

}
