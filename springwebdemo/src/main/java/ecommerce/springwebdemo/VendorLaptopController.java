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
import ecommerce.database.dao.products.LaptopDaoService;
import ecommerce.database.dao.products.MobileDaoService;
import ecommerce.database.model.NumberOfProducts;
import ecommerce.database.model.Product;
import ecommerce.database.model.Vendor;
import ecommerce.database.model.products.Laptop;
import ecommerce.database.model.products.Mobile;

@Controller
public class VendorLaptopController {

	@Autowired
     private LaptopDaoService laptopDaoService;
	
	@Autowired
     private	SaveImage saveImage;
	
	@Autowired
	private ProductDaoService productDaoService;
	
	
	@PostMapping("/vendor/addlaptop")
	public String addLaptop(@ModelAttribute("laptop") Laptop laptop,HttpSession session,HttpServletRequest  request)
	{
		laptop.setVendor((Vendor)session.getAttribute("vendor"));
		
		List<NumberOfProducts> numberOfProductsList=listOfProducts(laptop);
		
		laptop.setNumberOfProducts(numberOfProductsList);
		
		
		if(laptopDaoService.addLaptop(laptop))
		{			
			saveImage.saveImage(laptop, request);
			session.setAttribute("products",productDaoService.getAllProducts((Vendor)session.getAttribute("vendor")));
			return "redirect:products";
			
		}else {
			return "addproduct";
		}
	}
	
	@GetMapping("/vendor/editlaptopdetails/{productId}")
	public String editProduct(@PathVariable("productId") long productId, Model model) {
		model.addAttribute("laptop",laptopDaoService.retrieveLaptopById(productId));
		return "editlaptop";
	}
	
	@PostMapping("/vendor/editlaptopdetails")
	public String editMobileDetails(@ModelAttribute("laptop") Laptop laptop, HttpServletRequest request) {
		if (!laptop.getImage().isEmpty()) {
			saveImage.saveImage(laptop, request);
		}
		if (laptopDaoService.updateLaptop(laptop)) {

			return "redirect:products";

		} else {
			
			return "editlaptopdetails";
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
