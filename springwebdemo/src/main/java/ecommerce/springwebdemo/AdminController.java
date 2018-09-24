package ecommerce.springwebdemo;

import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ecommerce.database.dao.admin.AdminDao;

@Controller
public class AdminController {
	
	@Autowired
	private AdminDao adminDao;
	
	@GetMapping("adminlogin")
	public String adminLogin(Principal principal,Map<String, Object> vendor)
	{
	  	 
	  	
	  		return "adminlogin";
	  	 
	}
	
	@GetMapping("/admin/adminpage")
	public String adminPage(Model model){
		
		 model.addAttribute("vendorslist", adminDao.getVendors());
		return "adminpage";
		
	}

}
