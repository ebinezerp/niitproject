package ecommerce.database.model.products;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import ecommerce.database.model.Product;
import ecommerce.database.model.Vendor;

@Entity
@Component("AirConditioner")
public class AirConditioner extends Product{

	private String airconditioner_type;
	private byte airconditioner_powersavings_rating;
	private String airconditioner_description;
	
	public String getAirconditioner_type() {
		return airconditioner_type;
	}
	public void setAirconditioner_type(String airconditioner_type) {
		this.airconditioner_type = airconditioner_type;
	}
	public byte getAirconditioner_powersavings_rating() {
		return airconditioner_powersavings_rating;
	}
	public void setAirconditioner_powersavings_rating(byte airconditioner_powersavings_rating) {
		this.airconditioner_powersavings_rating = airconditioner_powersavings_rating;
	}
	public String getAirconditioner_description() {
		return airconditioner_description;
	}
	public void setAirconditioner_description(String airconditioner_description) {
		this.airconditioner_description = airconditioner_description;
	}
	
	
	
}
