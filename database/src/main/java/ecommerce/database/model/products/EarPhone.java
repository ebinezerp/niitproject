package ecommerce.database.model.products;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

import ecommerce.database.model.Product;

@Entity
@Component("EarPhone")
public class EarPhone extends Product{
	
	
	private boolean wireless;
	private boolean microphone;
	
	public boolean isWireless() {
		return wireless;
	}
	public void setWireless(boolean wireless) {
		this.wireless = wireless;
	}
	public boolean isMicrophone() {
		return microphone;
	}
	public void setMicrophone(boolean microphone) {
		this.microphone = microphone;
	}
	 

}
