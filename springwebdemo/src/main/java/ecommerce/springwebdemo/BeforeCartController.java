package ecommerce.springwebdemo;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ecommerce.database.dao.ProductDaoService;
import ecommerce.database.dao.SubCategoryDaoService;
import ecommerce.database.dao.products.MobileDaoService;

@Controller
public class BeforeCartController {
	
	@Autowired
	private ProductDaoService productDaoService;
	
	@Autowired
	private SubCategoryDaoService subCategoryDaoService;
	
	@Autowired
	private MobileDaoService mobileDaoService;

	@GetMapping("display/{productId}")
	public String viewProduct(@PathVariable("productId")long productId,Model model)
	{
		if(productDaoService.getProduct(productId).getSubCategory().getSubCategory_name().equals("mobile"))
		{
			model.addAttribute("mobile", productDaoService.getProduct(productId));
			return "buymobile";
		}else if(productDaoService.getProduct(productId).getSubCategory().getSubCategory_name().equals("laptop")){
			model.addAttribute("laptop", productDaoService.getProduct(productId));
			
			return "buylaptop";
		}else if(productDaoService.getProduct(productId).getSubCategory().getSubCategory_name().equals("refrigerator")){
			model.addAttribute("refrigerator", productDaoService.getProduct(productId));
		
			return "buyrefrigerator";
		}else if(productDaoService.getProduct(productId).getSubCategory().getSubCategory_name().equals("airconditioner")){
			model.addAttribute("airconditioner", productDaoService.getProduct(productId));
	
			return "buyairconditioner";
		}else if(productDaoService.getProduct(productId).getSubCategory().getSubCategory_name().equals("television")){
			model.addAttribute("television", productDaoService.getProduct(productId));
			
			return "buytelevision";
		}else if(productDaoService.getProduct(productId).getSubCategory().getSubCategory_name().equals("earphones")){
			model.addAttribute("earphones", productDaoService.getProduct(productId));
		
			return "buyearphones";
		}else if(productDaoService.getProduct(productId).getSubCategory().getSubCategory_name().equals("ssd")){
			model.addAttribute("ssd", productDaoService.getProduct(productId));
			
			return "buyssd";
		}else if(productDaoService.getProduct(productId).getSubCategory().getSubCategory_name().equals("powerbank")){
			model.addAttribute("powerbank", productDaoService.getProduct(productId));
			
			return "buypowerbank";
		}else if(productDaoService.getProduct(productId).getSubCategory().getSubCategory_name().equals("watch")){
			model.addAttribute("watch", productDaoService.getProduct(productId));
			
			return "buywatch";
		}else{
			model.addAttribute("shoe", productDaoService.getProduct(productId));
			return "buyshoe";
		}
	
	}
}
