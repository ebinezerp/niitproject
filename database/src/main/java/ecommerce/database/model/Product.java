package ecommerce.database.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Component("Product")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long productId;
	private String product_brand;
	private String product_model;
	private short warrantyInMonths;
    private String product_color;
    private int noOfProducts;
    
   
	@ManyToOne
    private Vendor vendor;
    
    @ManyToOne
    private SubCategory subCategory;
    
	public SubCategory getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}
	public String getProduct_color() {
		return product_color;
	}
	public void setProduct_color(String product_color) {
		this.product_color = product_color;
	}
	public Vendor getVendor() {
		return vendor;
	}
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getProduct_brand() {
		return product_brand;
	}
	public void setProduct_brand(String product_brand) {
		this.product_brand = product_brand;
	}
	public String getProduct_model() {
		return product_model;
	}
	public void setProduct_model(String product_model) {
		this.product_model = product_model;
	}
	public short getWarrantyInMonths() {
		return warrantyInMonths;
	}
	public void setWarrantyInMonths(short warrantyInMonths) {
		this.warrantyInMonths = warrantyInMonths;
	}
	
	 public int getNoOfProducts() {
			return noOfProducts;
		}
		public void setNoOfProducts(int noOfProducts) {
			this.noOfProducts = noOfProducts;
		}
    
}
