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
import ecommerce.database.dao.products.PowerBankDaoService;
import ecommerce.database.model.NumberOfProducts;
import ecommerce.database.model.Product;
import ecommerce.database.model.Vendor;
import ecommerce.database.model.products.Mobile;
import ecommerce.database.model.products.PowerBank;

@Controller
public class VendorPowerBankController {
	
	@Autowired
	private PowerBankDaoService powerBankDaoService;
	@Autowired
	private SaveImage saveImage;
	
	@PostMapping("addpowerbank")
	public String addMobile(@ModelAttribute("powerbank") PowerBank powerBank,HttpSession session,HttpServletRequest request)
	{
		powerBank.setVendor((Vendor)session.getAttribute("vendor"));
		
		List<NumberOfProducts> numberOfProductsList=listOfProducts(powerBank);
		
		powerBank.setNumberOfProducts(numberOfProductsList);
		
		
		if(powerBankDaoService.addPowerBank(powerBank))
		{	
					
		 saveImage.saveImage(powerBank,request);
		 
			return "redirect:products";
			
		}else {
			return "addpowerbank";
		}
	}
	
	
	@GetMapping("editpowerbankdetails/{productId}")
	public String editProduct(@PathVariable("productId") long productId, Model model) {
		model.addAttribute("ssd", powerBankDaoService.retrievePowerBankById(productId));
		return "editpowerbank";
	}
	

	@PostMapping("editpowerbankdetails")
	public String editMobileDetails(@ModelAttribute("powerbank") PowerBank powerBank, HttpServletRequest request) {
		if (!powerBank.getImage().isEmpty()) {
			saveImage.saveImage(powerBank, request);
		}
		if (powerBankDaoService.updatePowerBank(powerBank)) {

			return "redirect:products";

		} else {
			return "editpowerbankdetails";
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
