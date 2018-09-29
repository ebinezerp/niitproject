package ecommerce.springwebdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ecommerce.database.dao.CustomerDaoService;
import ecommerce.database.model.Customer;

@Controller
public class CustomerController {

	@Autowired
    private	CustomerDaoService customerDaoService;
	
	
	@GetMapping("customerlogin")
	public String customerLogin()
	{
		return "customerlogin";
	}
	
	
	@GetMapping("customersignup")
	public ModelAndView customerSignup()
	{
		ModelAndView modelAndView=new ModelAndView("customersignup");
		modelAndView.addObject("customer",new Customer());
		return modelAndView;
	}
	
	@PostMapping("customersignup")
	public String addCustomer(@ModelAttribute("customer")Customer customer)
	{
		if(customerDaoService.addCustomer(customer)==true)
		{
			return "customerlogin";
		}else {
			return "customersignup";
		}
	}
}