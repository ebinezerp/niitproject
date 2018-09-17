package ecommerce.database.model.products;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

import ecommerce.database.model.Product;

@Entity
@Component("Shoe")
public class Shoe extends Product {
	
	private String gender;
	private String shoetype;
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getShoetype() {
		return shoetype;
	}
	public void setShoetype(String shoetype) {
		this.shoetype = shoetype;
	}
	

}
