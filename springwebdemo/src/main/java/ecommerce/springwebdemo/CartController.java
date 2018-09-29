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
	
    @Autowired
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
	public String addToCart(Principal principal, HttpServletRequest request) {

		
		long productId=Integer.parseInt(request.getParameter("productId"));
		int quantity=Integer.parseInt(request.getParameter("numberOfProducts"));
		 int unitprice=productDaoService.getProduct(productId).getPrice();
		 Product product=productDaoService.getProduct(productId);
		 
		if(checkAvailabilityOfProducts(productId, quantity)==true)
		{
			customer=customerDaoService.getCustomerByEmail(principal.getName());
			cart=cartDaoService.getCartByCustId(customer.getCustomer_id());
			if(cart==null)
			{
				cart=new Cart();
				 cartItems=new CartItems();
	                List<CartItemIds> cartItemIdsList=new ArrayList<CartItemIds>();
	                List<CartItems> cartItemsList=new ArrayList<CartItems>();
	                List<NumberOfProducts> numberOfProductsList=noOfProductsDaoService.getNumberOfProducts(productId);
	                
	                for(int i=0;i<quantity;i++)
	                {
	                   cartItemIds=new CartItemIds();	
	                   numberOfProducts=new NumberOfProducts();
	                   numberOfProducts=numberOfProductsList.get(i);
	                   numberOfProducts.setBought(true);
	                   cartItemIds.setNumberOfProducts(numberOfProducts);
	                   cartItemIds.setCartItems(cartItems);
	                   cartItemIdsList.add(cartItemIds);				                	
	                }
	                cartItems.setUnitPrice(unitprice);
	                cartItems.setTotalPrice(unitprice*quantity);
	                cartItems.setQuantity(quantity);
	                cartItems.setCartItemIdsList(cartItemIdsList);
	                cartItems.setCart(cart);
	                cartItemsList.add(cartItems);
	                cart.setCartItemsList(cartItemsList);
	                cart.setCustomer(customer);
	                cart.setNetPrice(quantity*unitprice);
	                cart.setNoOfItems(quantity);
	                cartDaoService.addCart(cart);
	                
	                return "cart";
				
				
			}else {
				
			       cartItems=checkIfProductAlreadyExists(productId, cart);
				
			              if(cartItems!=null)
			                {
			            	  
			            	  
			            	  List<CartItemIds> cartItemIdsList=new ArrayList<CartItemIds>();
				              List<CartItems> cartItemsList=new ArrayList<CartItems>();
				              cartItemsList=cart.getCartItemsList();
				              int position=cartItemsList.indexOf(cartItems);
				              List<NumberOfProducts> numberOfProductsList=noOfProductsDaoService.getNumberOfProducts(productId);
				               cartItemIdsList=cartItemIdsDaoService.getAllRelatedCartItemIds(cartItems.getCartItemsId());
				               for(int i=0;i<quantity;i++)
				                {
				                   cartItemIds=new CartItemIds();
				                   NumberOfProducts numberOfProducts=new NumberOfProducts();
				                   numberOfProducts=numberOfProductsList.get(i);
				                   numberOfProducts.setBought(true);
				                   cartItemIds.setNumberOfProducts(numberOfProducts);
				                   cartItemIds.setCartItems(cartItems);
				                   cartItemIdsList.add(cartItemIds);				                	
				                }
				               cartItems.setCartItemIdsList(cartItemIdsList);
				               cartItemsList.add(position, cartItems);
			            	  cart.setCartItemsList(cartItemsList);
				                cart.setNetPrice((quantity*unitprice)+cart.getNetPrice());
				                cart.setNoOfItems(quantity+cart.getNoOfItems());
			            	  cartDaoService.updateCart(cart);	  
			            	  
				              return "cart";
			                 }else {
				
				                cartItems=new CartItems();
				                List<CartItemIds> cartItemIdsList=new ArrayList<CartItemIds>();
				                List<CartItems> cartItemsList=new ArrayList<CartItems>();
				                List<NumberOfProducts> numberOfProductsList=noOfProductsDaoService.getNumberOfProducts(productId);
				                for(int i=0;i<quantity;i++)
				                {
				                   cartItemIds=new CartItemIds();
				                   numberOfProducts=new NumberOfProducts();
				                   numberOfProducts=numberOfProductsList.get(i);
				                   numberOfProducts.setBought(true);
				                   cartItemIds.setNumberOfProducts(numberOfProducts);
				                   cartItemIds.setCartItems(cartItems);
				                   cartItemIdsList.add(cartItemIds);				                	
				                }
				                cartItems.setUnitPrice(unitprice);
				                cartItems.setTotalPrice(unitprice*quantity);
				                cartItems.setQuantity(quantity);
				                cartItems.setCartItemIdsList(cartItemIdsList);
				                cartItems.setCart(cart);
				                cartItemsList.add(cartItems);
				                cart.setCartItemsList(cartItemsList);
				                cart.setNetPrice((quantity*unitprice)+cart.getNetPrice());
				                cart.setNoOfItems(quantity+cart.getNoOfItems());
				                cartDaoService.updateCart(cart);
				                return "cart";
			                }
			
			
			      }
			
		}else {
			
			return "buymobile";
		}
		
		
		
		
	}
	
	public CartItems checkIfProductAlreadyExists(long productId,Cart cart)
	{
       List<CartItems> cartItemsList=cart.getCartItemsList();
       for(CartItems c:cartItemsList)
       {
    	   if(c.getCartItemIdsList().get(0).getNumberOfProducts().getProduct().getProductId()==productId)
    	   {
    		   return c;
    	   }
       }
       return null;
	}
	
	
	public boolean checkAvailabilityOfProducts(long productId,int quantity)
	{
		if(noOfProductsDaoService.getNumberOfProducts(productId).size()>=quantity)
		{
			return true;
		}else {
			return false;
		}
	}

}
