package ecommerce.springwebdemo;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
	public String addToCart(Principal principal, HttpServletRequest request,Model model) {

		
		long productId=Integer.parseInt(request.getParameter("productId"));
		int quantity=Integer.parseInt(request.getParameter("numberOfProducts"));
		 int unitprice=productDaoService.getProduct(productId).getPrice();
		 Product product=productDaoService.getProduct(productId);
		 customer=customerDaoService.getCustomerByEmail(principal.getName());
		 
		if(checkAvailabilityOfProducts(productId, quantity)==true)
		{
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
	                   noOfProductsDaoService.updateNumberOfProducts(numberOfProducts);
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
	                
	                return "redirect:/customer/cart";
				
				
			}else {
				
			       cartItems=checkIfProductAlreadyExists(productId, cart);
				
			              if(cartItems!=null)
			                {
			            	  
			            	  
			            	  updatingNumberOfProductsInCartItems(productId,quantity,unitprice,cartItems);
			            	  
				              return "redirect:/customer/cart";
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
				                   noOfProductsDaoService.updateNumberOfProducts(numberOfProducts);
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
				                return "redirect:/customer/cart";
			                }
			
			
			      }
			
		}else {
			
			return "index";
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
	
	
	@GetMapping("/customer/cart")
	public String displayCart(Principal principal,Model model)
	{
		Customer customer=customerDaoService.getCustomerByEmail(principal.getName());
		Cart cart=cartDaoService.getCartByCustId(customer.getCustomer_id());
		List<Product> products=new ArrayList<Product>();
		List<CartItems> cartItems=new ArrayList<CartItems>();
		cartItems=cartItemsDaoService.getCartItemsByCartId(cart.getCartId());
		List<CartItemIds> cartItemIds=new ArrayList<CartItemIds>();
		
		List<String> subcategoryname=new ArrayList<String>();
		
		for(CartItems items:cartItems)
		{
			cartItemIds=cartItemIdsDaoService.getAllRelatedCartItemIds(items.getCartItemsId());
			products.add(cartItemIds.get(0).getNumberOfProducts().getProduct());
		    subcategoryname.add(cartItemIds.get(0).getNumberOfProducts().getProduct().getSubCategory().getSubCategory_name());
		}
				
		model.addAttribute("product",products);
		model.addAttribute("name",subcategoryname);
		model.addAttribute("cartitem",cartItems);
	
		return "cart";
	}
	
	@GetMapping("/customer/addoneproduct/{cartItemsId}")
	public String addOneProductFromCart(@PathVariable("cartItemsId")long cartItemsId)
	{
          cartItems=cartItemsDaoService.getCartItemByCartItemsId(cartItemsId);
          System.out.println(cartItems);
	      List<CartItemIds> cartItemIdsList=cartItems.getCartItemIdsList();
	      long productId=cartItemIdsList.get(0).getNumberOfProducts().getProduct().getProductId();
	      int unitprice=cartItemIdsList.get(0).getNumberOfProducts().getProduct().getPrice();
	      if(checkAvailabilityOfProducts(productId, 1)==true)
	      {
	    	  if(updatingNumberOfProductsInCartItems(productId,1,unitprice,cartItems)==true)
	    	  {
	    		  return "redirect:/customer/cart";
	    	  }else {
	    		  return "redirect:/customer/cart";
	    	  }
	   
	      }else {
	    	  return "redirect:/customer/cart";
	      }
	}

	@GetMapping("/customer/removeoneproduct/{cartItemsId}")
	public String deleteOneProductFromCart(@PathVariable("cartItemsId")long cartItemsId)
	{
		cartItems=cartItemsDaoService.getCartItemByCartItemsId(cartItemsId);
		List<CartItemIds> cartItemIdsList=cartItems.getCartItemIdsList();
	      long productId=cartItemIdsList.get(0).getNumberOfProducts().getProduct().getProductId();
	      int unitprice=cartItemIdsList.get(0).getNumberOfProducts().getProduct().getPrice();
	      Cart cart=cartItems.getCart();
	      List<CartItems> cartItemsList=cart.getCartItemsList();
	      int position=cartItemsList.indexOf(cartItems);
	    NumberOfProducts numberOfProducts=  cartItemIdsList.get(0).getNumberOfProducts();
	    numberOfProducts.setBought(false);
	    noOfProductsDaoService.updateNumberOfProducts(numberOfProducts);
	    cartItemIdsDaoService.deleteCartItemIds(cartItemIdsList.get(0));
	    cartItemIdsList.remove(0);
	    cartItems.setQuantity(cartItems.getQuantity()-1);
        cartItems.setTotalPrice(cartItems.getTotalPrice()-(cartItems.getUnitPrice()));
        cartItems.setCartItemIdsList(cartItemIdsList);
        cartItemsList.add(position, cartItems);
 	  cart.setCartItemsList(cartItemsList);
         cart.setNetPrice(cart.getNetPrice()-unitprice);
         cart.setNoOfItems(cart.getNoOfItems()-1);
        if(cartDaoService.updateCart(cart)==true)
        {
        	return "redirect:/customer/cart";
        }else {
        	return "redirect:/customer/cart";
        }
         
	}
	
	public boolean updatingNumberOfProductsInCartItems(long productId,int quantity,int unitprice,CartItems cartItems)
	{
		Cart cart=cartItems.getCart();
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
              noOfProductsDaoService.updateNumberOfProducts(numberOfProducts);
              cartItemIds.setNumberOfProducts(numberOfProducts);
              cartItemIds.setCartItems(cartItems);
              cartItemIdsList.add(cartItemIds);				                	
           }
          cartItems.setQuantity(cartItems.getQuantity()+quantity);
          cartItems.setTotalPrice(cartItems.getTotalPrice()+(cartItems.getUnitPrice()*quantity));
          cartItems.setCartItemIdsList(cartItemIdsList);
          cartItemsList.add(position, cartItems);
   	  cart.setCartItemsList(cartItemsList);
           cart.setNetPrice((quantity*unitprice)+cart.getNetPrice());
           cart.setNoOfItems(quantity+cart.getNoOfItems());
   	return  cartDaoService.updateCart(cart);	 
	}
}
