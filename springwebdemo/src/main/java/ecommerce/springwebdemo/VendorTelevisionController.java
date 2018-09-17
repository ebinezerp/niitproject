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
import ecommerce.database.dao.products.TelevisionDaoService;
import ecommerce.database.model.NumberOfProducts;
import ecommerce.database.model.Product;
import ecommerce.database.model.Vendor;
import ecommerce.database.model.products.AirConditioner;
import ecommerce.database.model.products.Television;

public class VendorTelevisionController {
	
	@Autowired
	private TelevisionDaoService televisionDaoService;

	@Autowired
	private SaveImage saveImage;
	
	@Autowired
	private ProductDaoService productDaoService;
	
	
	@PostMapping("addtelevision")
	public String addRefrigerator(@ModelAttribute("television")Television television,HttpServletRequest request,HttpSession session)
	{
		television.setVendor((Vendor)session.getAttribute("vendor"));
		List<NumberOfProducts> noOfProducts=listOfProducts(television);
		
		television.setNumberOfProducts(noOfProducts);
		
		if(televisionDaoService.addTelevision(television))
		{
			saveImage.saveImage(television, request);
			
			return "redirect:products";
		}else {
			return "addproduct";
		}
	}

	
	@GetMapping("edittelevisiondetails/{productId}")
	public String editProduct(@PathVariable("productId")long productId, Model model)
	{
		model.addAttribute("refrigerator", televisionDaoService.retrieveTelevisionById(productId));
		return "editairconditioner";
	}
	
	@PostMapping("editairconditionerdetails")
	public String editMobileDetails(@ModelAttribute("airconditioner") Television television, HttpServletRequest request) {
		if (!television.getImage().isEmpty()) {
			saveImage.saveImage(television, request);
		}
		if (televisionDaoService.updateTelevision(television)) {

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
