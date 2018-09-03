package ecommerce.springwebdemo;

import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ecommerce.database.dao.VendorDaoService;
import ecommerce.database.model.Vendor;

@Controller
public class IndexController {

	
	
	@Autowired
	private VendorDaoService vendorDaoService;
	
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
	public String addVendor(@ModelAttribute("vendor") Vendor vendor)
	{
    	if(vendorDaoService.addVendor(vendor))
    	{
    		System.out.println(vendor.getVendor_name());
    		return "redirect:login";
    	}else {
    		return "signup";
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
	public String vendorLogin(@ModelAttribute("vendor") Vendor vendor,Model model)
	{
		
		//System.out.println(vendorDaoService.getVendorByEmail(vendor.getVendor_email()));
		if(vendorDaoService.vendorLogin(vendor.getVendor_email(), vendor.getVendor_password())!=null)
		 {
			
			System.out.println("login Successful");
			vendor=vendorDaoService.vendorLogin(vendor.getVendor_email(), vendor.getVendor_password());
			System.out.println(vendor.getVendor_name()+vendor.getCompany_name());
			model.addAttribute("vendor", vendor);
			return "profile";
		 }else {
			 System.out.println("login Unsuccessful");
			 return "redirect:login";
		 }
	}
}
