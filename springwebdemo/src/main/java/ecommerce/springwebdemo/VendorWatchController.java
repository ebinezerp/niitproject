package ecommerce.springwebdemo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ecommerce.database.dao.products.WatchDaoService;
import ecommerce.database.model.NumberOfProducts;
import ecommerce.database.model.Product;
import ecommerce.database.model.Vendor;
import ecommerce.database.model.products.Watch;

@Controller
public class VendorWatchController {

	@Autowired
	private WatchDaoService watchDaoService;
	@Autowired
	private SaveImage saveImage;
	
	@PostMapping("addwatch")
	public String addWatch(@ModelAttribute("watch") Watch watch,HttpSession session,HttpServletRequest request)
	{
		watch.setVendor((Vendor)session.getAttribute("vendor"));
		
		List<NumberOfProducts> numberOfProductsList=listOfProducts(watch);
		
		watch.setNumberOfProducts(numberOfProductsList);
		
		
		if(watchDaoService.addWatch(watch))
		{	
					
		 saveImage.saveImage(watch,request);
		 
			return "redirect:products";
			
		}else {
			return "addwatch";
		}
	}
	
	
	@GetMapping("editwatchdetails/{productId}")
	public String editProduct(@PathVariable("productId") long productId, Model model) {
		model.addAttribute("watch",watchDaoService.retrieveWatchById(productId));
		return "editwatch";
	}
	

	@PostMapping("editwatchdetails")
	public String editMobileDetails(@ModelAttribute("watch") Watch watch, HttpServletRequest request) {
		if (!watch.getImage().isEmpty()) {
			saveImage.saveImage(watch, request);
		}
		if (watchDaoService.updateWatch(watch)) {

			return "redirect:products";

		} else {
			return "editwatchdetails";
		}
	}
	
	private List<NumberOfProducts> listOfProducts(Product product)
	{
		List<NumberOfProducts> numberOfProductsList=new ArrayList<NumberOfProducts>();
		for(int i=1;i<=product.getNoOfProducts();i++)
		{
			NumberOfProducts numberOfProducts=new NumberOfProducts();
			numberOfProducts.setProduct(product);
			numberOfProductsList.add(numberOfProducts);
		}	
		return numberOfProductsList;
	}
	
}
