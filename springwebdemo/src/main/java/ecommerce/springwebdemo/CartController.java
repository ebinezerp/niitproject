package ecommerce.springwebdemo;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sun.mail.util.QDecoderStream;

import ecommerce.database.dao.CustomerDaoService;
import ecommerce.database.dao.NoOfProductsDaoService;
import ecommerce.database.dao.ProductDaoService;
import ecommerce.database.dao.cart.CartDaoService;
import ecommerce.database.dao.cart.CartItemIdsDaoService;
import ecommerce.database.dao.cart.CartItemsDaoService;
import ecommerce.database.dao.products.MobileDaoService;
import ecommerce.database.model.Customer;
import ecommerce.database.model.NumberOfProducts;
import ecommerce.database.model.Product;
import ecommerce.database.model.cart.Cart;
import ecommerce.database.model.cart.CartItemIds;
import ecommerce.database.model.cart.CartItems;

@Controller
public class CartController {
	
	@Autowired
	private CartDaoService cartDaoService;
	
	@Autowired
	private CustomerDaoService customerDaoService;
	
	@Autowired
	private Cart cart;
	
	@Autowired
	private Customer customer;
	

	private CartItems cartItems;
	
	@Autowired
	private CartItemsDaoService cartItemsDaoService;

	@Autowired
	private CartItemIds cartItemIds;
	
	@Autowired
	private ProductDaoService productDaoService;
	
	@Autowired
	private MobileDaoService mobileDaoService;
	
	@Autowired
	private NumberOfProducts numberOfProducts;
	
	@Autowired
	private NoOfProductsDaoService noOfProductsDaoService;

	
	@Autowired
	private CartItemIdsDaoService cartItemIdsDaoService;
	
	@GetMapping("/customer/addtocart")
	public String addToCart(Principal principal,HttpServletRequest request)
	{
		System.out.println(principal.getName());
		int productId=Integer.parseInt(request.getParameter("productId"));
		List<CartItems> cartItemsList=new ArrayList<CartItems>();
		List<CartItemIds> cartItemIdsList=new ArrayList<CartItemIds>();
		customer=customerDaoService.getCustomerByEmail(principal.getName());
		System.out.println(customer.getCustomer_id());
		Cart cart=cartDaoService.getCartByCustId(customer.getCustomer_id());
		Product product=null;
		 if(request.getParameter("productId")!=null)
		 {
		    	 product=productDaoService.getProduct(productId);
		 }else {
			 return "redirect:/buymobile";
		 }
		 int quantity=Integer.parseInt(request.getParameter("numberOfProducts"));
		 List<NumberOfProducts> numberOfproductsList=noOfProductsDaoService.getNumberOfProducts(productId);
		if(cart==null)
		{
		    cart=new Cart();
		    cart.setCustomer(customer);
		    cartItems.setUnitPrice(product.getPrice());
		   
		    cartItems.setQuantity(quantity);
		    cartItems.setTotalPrice(quantity*product.getPrice());
		    cartItems.setCart(cart);
		   
		    if(numberOfproductsList.size()>quantity)
		    {
		    	for(int i=0;i<quantity;i++)
		    	{
		    		cartItemIds.setNumberOfProducts(numberOfproductsList.get(i));
		    		cartItemIds.setCartItems(cartItems);
		    		cartItemIdsList.add(cartItemIds);
		    	}
		    	cartItems.setCartItemIdsList(cartItemIdsList);
		    	cartItemsList.add(cartItems);
		    	cart.setCartItemsList(cartItemsList);
		    	cart.setNetPrice(quantity*product.getPrice());
		    	cart.setNoOfItems(quantity);
		    	cartDaoService.addCart(cart);
		    	
		    	return "cart";
		    }
		    else {
				return "redirect:/buymobile";
			}
		}else {
			
			
			boolean b=false;
			List<CartItems> cartItemsList1=cart.getCartItemsList();
			NumberOfProducts numberOfProducts=new NumberOfProducts();
			for(CartItems c:cartItemsList1)
			{
			    if(c.getCartItemIdsList().get(0).getNumberOfProducts().getProduct().getProductId()==productId)
			    {
			    	c.setQuantity(c.getQuantity()+quantity);
			    	c.setTotalPrice(c.getTotalPrice()+(product.getPrice()*quantity));
			    	CartItemIds cartItemIds=new CartItemIds();
			    	cartItemIds.setCartItems(c);
			    	if(numberOfproductsList.size()>quantity)
				    {
				    	for(int i=0;i<quantity;i++)
				    	{
				    		cartItemIds.setNumberOfProducts(numberOfproductsList.get(i));
				    		cartItemIds.setCartItems(cartItems);
				    		cartItemIdsList.add(cartItemIds);
				    	}
				    	cartItems.setCartItemIdsList(cartItemIdsList);
				    	cartItemsList.add(cartItems);
				    	cart.setCartItemsList(cartItemsList);
				    	cart.setNetPrice(quantity*product.getPrice());
				    	cart.setNoOfItems(quantity);
				    	cartDaoService.addCart(cart);
				    	
				    	return "cart";
				    }
				    else {
						return "redirect:/buymobile";
					}
			        cartItemIds.setNumberOfProducts(numberOfProducts);
			    	
			    }
			  
			}
			
			
			
			
			
			
			/*cartItems.setUnitPrice(product.getPrice());
		    int quantity=Integer.parseInt(request.getParameter("numberOfProducts"));
		    cartItems.setQuantity(quantity);
		    cartItems.setTotalPrice(quantity*product.getPrice());
		    List<NumberOfProducts> numberOfproductsList=noOfProductsDaoService.getNumberOfProducts(productId);
		    if(numberOfproductsList.size()>quantity)
		    {
		    	cartItemIdsList=cartItemsDaoService.getCartItemByCartId(cart.getCartId()).getCartItemIdsList();
		    	
		    	for(int i=0;i<quantity;i++)
		    	{
		    		cartItemIds.setNumberOfProducts(numberOfproductsList.get(i));
		    		cartItemIds.setCartItems(cartItems);
		    		cartItemIdsList.add(cartItemIds);
		    	}
		    	cartItems.setCartItemIdsList(cartItemIdsList);
		    	
		    	cartItemsList=cartDaoService.getCartByCustId(customer.getCustomer_id()).getCartItemsList();
		    	cartItemsList.add(cartItems);
		    	
		    	cart.setCartItemsList(cartItemsList);
		    	
		    	cart.setNetPrice(cartDaoService.getCartByCustId(customer.getCustomer_id()).getNetPrice()+(quantity*product.getPrice()));
		    	cart.setNoOfItems(cartDaoService.getCartByCustId(customer.getCustomer_id()).getNoOfItems()+quantity);
		    	cartDaoService.updateCart(cart);	*/	    	
		    	return "cart";
		    }
		    		
		}
		
	}

