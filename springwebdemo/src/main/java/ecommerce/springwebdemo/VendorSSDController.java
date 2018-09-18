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

import ecommerce.database.dao.products.SSDDaoService;
import ecommerce.database.model.NumberOfProducts;
import ecommerce.database.model.Product;
import ecommerce.database.model.Vendor;
import ecommerce.database.model.products.Mobile;
import ecommerce.database.model.products.SSD;

@Controller
public class VendorSSDController {
    
	@Autowired
	private SSDDaoService ssdDaoService;
	
	@Autowired
	private SaveImage saveImage;
	
	@PostMapping("addssd")
	public String addSSD(@ModelAttribute("ssd") SSD ssd,HttpSession session,HttpServletRequest request)
	{
		ssd.setVendor((Vendor)session.getAttribute("vendor"));
		
		List<NumberOfProducts> numberOfProductsList=listOfProducts(ssd);
		
		ssd.setNumberOfProducts(numberOfProductsList);
		
		
		if(ssdDaoService.addSSD(ssd))
		{	
					
		 saveImage.saveImage(ssd,request);
		 
			return "redirect:products";
			
		}else {
			return "addssd";
		}
	}
	
	
	@GetMapping("editssddetails/{productId}")
	public String editSSD(@PathVariable("productId") long productId, Model model) {
		model.addAttribute("ssd", ssdDaoService.retrieveSSDById(productId));
		return "editssd";
	}
	

	@PostMapping("editssddetails")
	public String editSSDDetails(@ModelAttribute("ssd") SSD ssd, HttpServletRequest request) {
		if (!ssd.getImage().isEmpty()) {
			saveImage.saveImage(ssd, request);
		}
		if (ssdDaoService.updateSSD(ssd)) {

			return "redirect:products";

		} else {
			return "editssddetails";
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
