package ecommerce.database.model.products;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import ecommerce.database.model.Product;
import ecommerce.database.model.Vendor;

@Entity
@Component("Refrigerator")
public class Refrigerator extends Product{

	
	private short refrigerator_capacity;
	private short refrigerator_doors;
	private byte refrigerator_powersavings_rating;
	private String refrigerator_description;
	
	public short getRefrigerator_capacity() {
		return refrigerator_capacity;
	}
	public void setRefrigerator_capacity(short refrigerator_capacity) {
		this.refrigerator_capacity = refrigerator_capacity;
	}
	public short getRefrigerator_doors() {
		return refrigerator_doors;
	}
	public void setRefrigerator_doors(short refrigerator_doors) {
		this.refrigerator_doors = refrigerator_doors;
	}
	public byte getRefrigerator_powersavings_rating() {
		return refrigerator_powersavings_rating;
	}
	public void setRefrigerator_powersavings_rating(byte refrigerator_powersavings_rating) {
		this.refrigerator_powersavings_rating = refrigerator_powersavings_rating;
	}
	public String getRefrigerator_description() {
		return refrigerator_description;
	}
	public void setRefrigerator_description(String refrigerator_description) {
		this.refrigerator_description = refrigerator_description;
	}
	
	
	
}
