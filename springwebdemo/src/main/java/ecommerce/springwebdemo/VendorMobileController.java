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

import ecommerce.database.dao.ProductDaoService;
import ecommerce.database.dao.products.MobileDaoService;
import ecommerce.database.model.NumberOfProducts;
import ecommerce.database.model.Product;
import ecommerce.database.model.Vendor;
import ecommerce.database.model.products.Mobile;

@Controller
public class VendorMobileController {
	
	
	@Autowired
	private MobileDaoService mobileDaoService;
	
	@Autowired
     private	SaveImage saveImage;


	@PostMapping("/vendor/addmobile")
	public String addMobile(@ModelAttribute("mobile") Mobile mobile,HttpSession session,HttpServletRequest request)
	{
		mobile.setVendor((Vendor)session.getAttribute("vendor"));
		
		List<NumberOfProducts> numberOfProductsList=listOfProducts(mobile);
		
		mobile.setNumberOfProducts(numberOfProductsList);
		
		
		if(mobileDaoService.addMobile(mobile))
		{	
					
		 saveImage.saveImage(mobile,request);
		 
			return "redirect:products";
			
		}else {
			return "addproduct";
		}
	}
	
	
	@GetMapping("/vendor/editmobiledetails/{productId}")
	public String editProduct(@PathVariable("productId") long productId, Model model) {
		model.addAttribute("mobile", mobileDaoService.getMobile(productId));
		return "editmobile";
	}
	

	@PostMapping("/vendor/editmobiledetails")
	public String editMobileDetails(@ModelAttribute("mobile") Mobile mobile, HttpServletRequest request) {
		if (!mobile.getImage().isEmpty()) {
			saveImage.saveImage(mobile, request);
		}
		if (mobileDaoService.updateMobile(mobile)) {

			return "redirect:products";

		} else {
			return "editmobiledetails";
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
