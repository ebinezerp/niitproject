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

import ecommerce.database.dao.products.ShoeDaoService;
import ecommerce.database.model.NumberOfProducts;
import ecommerce.database.model.Product;
import ecommerce.database.model.Vendor;
import ecommerce.database.model.products.SSD;
import ecommerce.database.model.products.Shoe;

@Controller
public class VendorShoeController {

	@Autowired
	private ShoeDaoService shoeDaoService;
	@Autowired
	private SaveImage saveImage;
	
	@PostMapping("addshoe")
	public String addShoes(@ModelAttribute("shoe") Shoe shoe,HttpSession session,HttpServletRequest request)
	{
		shoe.setVendor((Vendor)session.getAttribute("vendor"));
		
		List<NumberOfProducts> numberOfProductsList=listOfProducts(shoe);
		
		shoe.setNumberOfProducts(numberOfProductsList);
		
		
		if(shoeDaoService.addShoes(shoe))
		{	
					
		 saveImage.saveImage(shoe,request);
		 
			return "redirect:products";
			
		}else {
			return "addshoe";
		}
	}
	
	
	@GetMapping("editshoedetails/{productId}")
	public String editShoes(@PathVariable("productId") long productId, Model model) {
		model.addAttribute("shoe",shoeDaoService.retrieveShoesById(productId));
		return "editssd";
	}
	

	@PostMapping("editssddetails")
	public String editShoeDetails(@ModelAttribute("ssd") Shoe shoe, HttpServletRequest request) {
		if (!shoe.getImage().isEmpty()) {
			saveImage.saveImage(shoe, request);
		}
		if (shoeDaoService.updateShoes(shoe)) {

			return "redirect:products";

		} else {
			return "editshoedetails";
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
