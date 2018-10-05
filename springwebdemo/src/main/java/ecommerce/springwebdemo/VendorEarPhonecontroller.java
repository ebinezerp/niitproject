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

import ecommerce.database.dao.products.EarPhoneDaoService;
import ecommerce.database.model.NumberOfProducts;
import ecommerce.database.model.Product;
import ecommerce.database.model.Vendor;
import ecommerce.database.model.products.EarPhone;
import ecommerce.database.model.products.Shoe;

@Controller
public class VendorEarPhonecontroller {
	
	@Autowired
	private EarPhoneDaoService earPhoneDaoService;

	@Autowired
	private SaveImage saveImage;
	
	@PostMapping("/vendor/addearphones")
	public String addEarphones(@ModelAttribute("earphones") EarPhone earphone,HttpSession session,HttpServletRequest request)
	{
		earphone.setVendor((Vendor)session.getAttribute("vendor"));
		
		List<NumberOfProducts> numberOfProductsList=listOfProducts(earphone);
		
		earphone.setNumberOfProducts(numberOfProductsList);
		
		
		if(earPhoneDaoService.addEarPhone(earphone))
		{	
					
		 saveImage.saveImage(earphone,request);
		 
			return "redirect:products";
			
		}else {
			return "addproduct";
		}
	}
	
	@GetMapping("/vendor/editearphonesdetails/{productId}")
	public String editEarphones(@PathVariable("productId") long productId, Model model) {
		model.addAttribute("earphones",earPhoneDaoService.retrieveEarPhoneById(productId));
		return "editearphones";
	}
	

	@PostMapping("/vendor/editearphonesdetails")
	public String editEarphonesDetails(@ModelAttribute("earphones") EarPhone earphone, HttpServletRequest request) {
		if (!earphone.getImage().isEmpty()) {
			saveImage.saveImage(earphone, request);
		}
		if (earPhoneDaoService.updateEarPhone(earphone)) {

			return "redirect:products";

		} else {
			return "editearphonesdetails";
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
