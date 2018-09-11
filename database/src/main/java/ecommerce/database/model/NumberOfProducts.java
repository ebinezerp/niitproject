package ecommerce.database.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;
import org.springframework.stereotype.Component;

@Entity
@Component
public class NumberOfProducts {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long productNumber;
	
	private boolean bought;
	
	@ManyToOne
	private Product product;

	public long getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(long productNumber) {
		this.productNumber = productNumber;
	}

	public boolean isBought() {
		return bought;
	}

	public void setBought(boolean bought) {
		this.bought = bought;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
	
}
