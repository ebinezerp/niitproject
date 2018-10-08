package ecommerce.springwebdemo;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.sql.ordering.antlr.OrderByFragmentRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ecommerce.database.dao.CustomerDaoService;
import ecommerce.database.dao.cart.CartDaoService;
import ecommerce.database.dao.cart.CartItemIdsDaoService;
import ecommerce.database.dao.cart.CartItemsDaoService;
import ecommerce.database.dao.order.OrderDaoService;
import ecommerce.database.dao.order.OrderedItemIdsDaoService;
import ecommerce.database.dao.order.OrderedItemsDaoService;
import ecommerce.database.model.Customer;
import ecommerce.database.model.NumberOfProducts;
import ecommerce.database.model.cart.Cart;
import ecommerce.database.model.cart.CartItemIds;
import ecommerce.database.model.cart.CartItems;
import ecommerce.database.model.order.Order;
import ecommerce.database.model.order.OrderedItemIds;
import ecommerce.database.model.order.OrderedItems;

@Controller
public class OrderController {
	
	@Autowired
	private OrderDaoService orderDaoService;
	
	@Autowired
	private OrderedItemsDaoService orderedItemsDaoService;
	
	@Autowired
	private OrderedItemIdsDaoService orderedItemIdsDaoService;

	@Autowired
	private CartDaoService cartDaoService;
	
	@Autowired
	private Cart cart;
	
	@Autowired
	private List<CartItems> cartItemsList;
	
	@Autowired
	private List<CartItemIds> cartItemIdsList;
	
	@Autowired
	private CartItems cartItems;
	
	@Autowired
	private CartItemIds cartItemIds;
	
	@Autowired
	private CartItemsDaoService cartItemsDaoService;
	
	@Autowired
	private CartItemIdsDaoService cartItemIdsDaoService;
	
	@Autowired
	private NumberOfProducts numberOfProducts;
	
	@Autowired
	private Order order;
	
	@Autowired
	private OrderedItems orderedItems;
	
	@Autowired
	private OrderedItemIds orderedItemIds;
	
	@Autowired
	private List<OrderedItemIds> orderedItemIdsList;
	
	@Autowired
	private List<OrderedItems> orderedItemsList;
	
	@Autowired
	private Customer customer;
	
	@Autowired
	private CustomerDaoService customerDaoService;

	
	private Date sqlDate;
	
	
	private Timestamp timestamp;
	
	@GetMapping("/customer/placeorder/{customerId}")
	public String placeOrder(@PathVariable("customerId")long customerId,Model model)
	{
		cart=cartDaoService.getCartByCustId(customerId);
		customer=customerDaoService.getCustomerById(customerId);
		cartItemsList=new ArrayList<CartItems>();
		cartItemsList=cartItemsDaoService.getCartItemsByCartId(cart.getCartId());
        orderedItemIdsList=new ArrayList<OrderedItemIds>();
        orderedItemsList=new ArrayList<OrderedItems>();
		
		for(CartItems cartItems:cartItemsList)
		{
			cartItemIdsList=new ArrayList<CartItemIds>();
			cartItemIdsList=cartItemIdsDaoService.getAllRelatedCartItemIds(cartItems.getCartItemsId());
			for(CartItemIds cartItemIds:cartItemIdsList)
			{
				numberOfProducts=new NumberOfProducts();
				numberOfProducts=cartItemIds.getNumberOfProducts();
	            orderedItemIds=new OrderedItemIds();
	            orderedItemIds.setNumberOfProducts(numberOfProducts);
	            orderedItemIds.setOrderedItems(orderedItems);
	            orderedItemIdsList.add(orderedItemIds);
			}
			orderedItems=new OrderedItems();
		    orderedItems.setOrderedItemIdsList(orderedItemIdsList);
		    orderedItems.setQuantity(cartItems.getQuantity());
		    orderedItems.setUnitPrice(cartItems.getUnitPrice());
		    orderedItems.setTotalPrice(cartItems.getTotalPrice());
			orderedItemIds.setOrderedItems(orderedItems);
			orderedItemsList.add(orderedItems);
		}
		order=new Order();
		order.setCustomer(customer);
		order.setNetPrice(cart.getNetPrice());
		order.setNoOfItems(cart.getNoOfItems());
		order.setOrderedItemsList(orderedItemsList);
		order.setStatus("ordered");
	    sqlDate=new Date(new java.util.Date().getTime());
	    timestamp=new Timestamp(new java.util.Date().getTime());
	    
	    order.setDate(sqlDate);
	    order.setTimestamp(timestamp);
	    
	    if(orderDaoService.addOrder(order)==true)
	    {
	    	for(CartItems cartItems:cartItemsList)
	    	{
	    		cartItemIdsDaoService.deleteAllRelatedCartItemIds(cartItems.getCartItemsId());
	    	}
	    cartItemsDaoService.deleteAllRelatedCartItems(cart.getCartId());
	    cart.setCartItemsList(null);
	    cart.setNetPrice(0);
	    cart.setNoOfItems(0);
	    cartDaoService.updateCart(cart);
	    	return "order";
	    }else {
	    	model.addAttribute("message","Sorry,Order Cannot be placed.");
	    	return "order";
	    }
	  
	  
	}
}
