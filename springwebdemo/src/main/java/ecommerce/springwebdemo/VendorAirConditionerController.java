package ecommerce.springwebdemo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ecommerce.database.dao.ProductDaoService;
import ecommerce.database.dao.products.AirConditionerDaoService;
import ecommerce.database.model.NumberOfProducts;
import ecommerce.database.model.Product;
import ecommerce.database.model.Vendor;
import ecommerce.database.model.products.AirConditioner;
import ecommerce.database.model.products.Refrigerator;

public class VendorAirConditionerController {
	
	@Autowired
	private AirConditionerDaoService airConditionerDaoService;

	@Autowired
	private SaveImage saveImage;
	
	@Autowired
	private ProductDaoService productDaoService;


	
	@PostMapping("addairconditioner")
	public String addRefrigerator(@ModelAttribute("airconditioner")AirConditioner airConditioner,HttpServletRequest request,HttpSession session)
	{
		airConditioner.setVendor((Vendor)session.getAttribute("vendor"));
		List<NumberOfProducts> noOfProducts=listOfProducts(airConditioner);
		
		airConditioner.setNumberOfProducts(noOfProducts);
		
		if(airConditionerDaoService.addAirConditioner(airConditioner))
		{
			saveImage.saveImage(airConditioner, request);
			
			return "redirect:products";
		}else {
			return "addproduct";
		}
	}

	
	@GetMapping("editairconditionerdetails/{productId}")
	public String editProduct(@PathVariable("productId")long productId, Model model)
	{
		model.addAttribute("refrigerator", airConditionerDaoService.retrieveAirConditionerById(productId));
		return "editairconditioner";
	}
	
	@PostMapping("editairconditionerdetails")
	public String editMobileDetails(@ModelAttribute("airconditioner") AirConditioner airConditioner, HttpServletRequest request) {
		if (!airConditioner.getImage().isEmpty()) {
			saveImage.saveImage(airConditioner, request);
		}
		if (airConditionerDaoService.updateAirConditioner(airConditioner)) {

			return "redirect:products";

		} else {
			return "editairconditionerdetails";
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
