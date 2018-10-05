package ecommerce.springwebdemo;

import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ecommerce.database.dao.VendorDaoService;
import ecommerce.database.dao.admin.AdminDao;
import ecommerce.database.model.Vendor;

@Controller
public class AdminController {
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private VendorDaoService vendorDaoService;
	
	@GetMapping("/adminlogin")
	public String adminLogin(Principal principal,Map<String, Object> vendor)
	{
	  	 
	  	
	  		return "adminlogin";
	  	 
	}
	
	@GetMapping("/admin/adminpage")
	public String adminPage(Model model){
		
		System.out.println(adminDao.getVendors());
		 model.addAttribute("vendorslist", adminDao.getVendors());
		return "adminpage";
		
	}
	
	@GetMapping("/admin/accept/{vendor_id}")
	public String acceptVendor(@PathVariable("vendor_id")int vendor_id)
	{
		Vendor vendor = vendorDaoService.getVendorById(vendor_id);
		vendor.setVendor_active(true);
		vendorDaoService.editVendor(vendor);
		return "redirect:/admin/adminpage";
	}
	
	@GetMapping("/admin/reject/{vendor_id}")
	public String rejectVendor(@PathVariable("vendor_id")int vendor_id)
	{
		Vendor vendor=vendorDaoService.getVendorById(vendor_id);
		vendor.setVendor_active(false);
		vendorDaoService.editVendor(vendor);
		return "redirect:/admin/adminpage";		
	}

}
