package ecommerce.database.model.products;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

import ecommerce.database.model.Product;

@Entity
@Component("SSD")
public class SSD extends Product {

	private int storage;

	public int getStorage() {
		return storage;
	}

	public void setStorage(int storage) {
		this.storage = storage;
	}
	
}
