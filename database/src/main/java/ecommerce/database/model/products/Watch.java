package ecommerce.database.model.products;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

import ecommerce.database.model.Product;

@Entity
@Component("Watch")
public class Watch extends Product{
	
	private String gender;
	private String analogOrDigital;
	private String strapType;
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAnalogOrDigital() {
		return analogOrDigital;
	}
	public void setAnalogOrDigital(String analogOrDigital) {
		this.analogOrDigital = analogOrDigital;
	}
	public String getStrapType() {
		return strapType;
	}
	public void setStrapType(String strapType) {
		this.strapType = strapType;
	}
	

}
