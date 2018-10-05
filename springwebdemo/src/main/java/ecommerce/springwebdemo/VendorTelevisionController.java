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
import ecommerce.database.dao.products.TelevisionDaoService;
import ecommerce.database.model.NumberOfProducts;
import ecommerce.database.model.Product;
import ecommerce.database.model.Vendor;
import ecommerce.database.model.products.AirConditioner;
import ecommerce.database.model.products.Television;

@Controller
public class VendorTelevisionController {
	
	@Autowired
	private TelevisionDaoService televisionDaoService;

	@Autowired
	private SaveImage saveImage;
	
	@Autowired
	private ProductDaoService productDaoService;
	
	
	@PostMapping("/vendor/addtelevision")
	public String addTelevision(@ModelAttribute("television")Television television,HttpServletRequest request,HttpSession session)
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

	
	@GetMapping("/vendor/edittelevisiondetails/{productId}")
	public String editProduct(@PathVariable("productId")long productId, Model model)
	{
		model.addAttribute("television", televisionDaoService.retrieveTelevisionById(productId));
		return "edittelevision";
	}
	
	@PostMapping("/vendor/edittelevisiondetails")
	public String editMobileDetails(@ModelAttribute("television") Television television, HttpServletRequest request) {
		if (!television.getImage().isEmpty()) {
			saveImage.saveImage(television, request);
		}
		if (televisionDaoService.updateTelevision(television)) {

			return "redirect:products";

		} else {
			return "edittelevisiondetails";
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
