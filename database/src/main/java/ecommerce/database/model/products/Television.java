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
@Component("Television")
public class Television extends Product{

	private short  television_size;
	private byte television_powersaving_rating;
	private String television_type;
	private String television_description;
	private byte television_powersavings_rating;
	
	public short getTelevision_size() {
		return television_size;
	}
	public void setTelevision_size(short television_size) {
		this.television_size = television_size;
	}
	public byte getTelevision_powersaving_rating() {
		return television_powersaving_rating;
	}
	public void setTelevision_powersaving_rating(byte television_powersaving_rating) {
		this.television_powersaving_rating = television_powersaving_rating;
	}
	public String getTelevision_type() {
		return television_type;
	}
	public void setTelevision_type(String television_type) {
		this.television_type = television_type;
	}
	public String getTelevision_description() {
		return television_description;
	}
	public void setTelevision_description(String television_description) {
		this.television_description = television_description;
	}
	
	
	
	
	
}
