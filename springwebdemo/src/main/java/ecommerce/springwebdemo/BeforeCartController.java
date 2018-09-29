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
		}else {
			
			return "";
		}
	
	}
}
