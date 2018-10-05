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
import ecommerce.database.dao.products.RefrigeratorDaoService;
import ecommerce.database.model.NumberOfProducts;
import ecommerce.database.model.Product;
import ecommerce.database.model.Vendor;
import ecommerce.database.model.products.Mobile;
import ecommerce.database.model.products.Refrigerator;

@Controller
public class VendorRefrigeratorController {
	
	@Autowired
	private RefrigeratorDaoService refrigeratorDaoService;

	@Autowired
	private SaveImage saveImage;
	

	
	@PostMapping("/vendor/addrefrigerator")
	public String addRefrigerator(@ModelAttribute("refrigerator")Refrigerator refrigerator,HttpServletRequest request,HttpSession session)
	{
		refrigerator.setVendor((Vendor)session.getAttribute("vendor"));
		List<NumberOfProducts> noOfProducts=listOfProducts(refrigerator);
		
		refrigerator.setNumberOfProducts(noOfProducts);
		
		if(refrigeratorDaoService.addRefrigerator(refrigerator))
		{
			saveImage.saveImage(refrigerator, request);
			
			return "redirect:products";
		}else {
			return "addproduct";
		}
	}

	
	@GetMapping("/vendor/editrefrigeratordetails/{productId}")
	public String editProduct(@PathVariable("productId")long productId, Model model)
	{
		model.addAttribute("refrigerator", refrigeratorDaoService.retrieveRefrigeratorById(productId));
		return "editrefrigerator";
	}
	
	@PostMapping("/vendor/editrefrigeratordetails")
	public String editrefrigeratorDetails(@ModelAttribute("refrigerator") Refrigerator refrigerator, HttpServletRequest request) {
		if (!refrigerator.getImage().isEmpty()) {
			saveImage.saveImage(refrigerator, request);
		}
		if (refrigeratorDaoService.updateRefrigerator(refrigerator)) {

			return "redirect:products";

		} else {
			return "editrefrigeratordetails";
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
