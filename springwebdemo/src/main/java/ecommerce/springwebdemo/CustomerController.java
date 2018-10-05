package ecommerce.springwebdemo;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ecommerce.database.dao.CustomerDaoService;
import ecommerce.database.dao.cart.CartDaoService;
import ecommerce.database.dao.cart.CartItemIdsDaoService;
import ecommerce.database.dao.cart.CartItemsDaoService;
import ecommerce.database.model.Customer;
import ecommerce.database.model.cart.Cart;
import ecommerce.database.model.cart.CartItemIds;
import ecommerce.database.model.cart.CartItems;

@Controller
public class CustomerController {

	@Autowired
    private	CustomerDaoService customerDaoService;
	
	@Autowired
	private CartDaoService cartDaoService;
	
	@Autowired
	private Cart cart;
	
	@Autowired
	private CartItems cartItems;
	
	@Autowired
	private CartItemIdsDaoService cartItemIdsDaoService;
	
	@Autowired
	private CartItemsDaoService cartItemsDaoService;
	
	@Autowired
	private CartItemIds cartItemIds;
	
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
	
	 @GetMapping("/customer/clearcart")
	    public String clearCart(Principal principal)
	    {
		     Customer customer=customerDaoService.getCustomerByEmail(principal.getName());
	    	 cart=cartDaoService.getCartByCustId(customer.getCustomer_id());
	    	 
	    	 List<CartItems> cartItemsList=cartItemsDaoService.getCartItemsByCartId(cart.getCartId());
	    	 for(CartItems item:cartItemsList)
	    	 {
	    		System.out.println(cartItemIdsDaoService.deleteAllRelatedCartItemIds(item.getCartItemsId()));
	    	 }
	        System.out.println( cartItemsDaoService.deleteAllRelatedCartItems(cart.getCartId()));
	         cart.setCartItemsList(null);
	         cart.setNetPrice(0);
	         cart.setNoOfItems(0);
	         cartDaoService.updateCart(cart);
	        return "index";
	    }
}