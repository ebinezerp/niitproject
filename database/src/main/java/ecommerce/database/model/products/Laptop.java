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
@Component("Laptop")
public class Laptop extends Product{
	
	private int laptop_ram;
	private int laptop_rom;
	private int laptop_processor;
	private String laptop_os;
    private int laptop_weight;
    private int laptop_size;
    private int laptop_graphic_card;
    private String laptop_description;
    
    
	public String getLaptop_description() {
		return laptop_description;
	}
	public void setLaptop_description(String laptop_description) {
		this.laptop_description = laptop_description;
	}
	public int getLaptop_ram() {
		return laptop_ram;
	}
	public void setLaptop_ram(int laptop_ram) {
		this.laptop_ram = laptop_ram;
	}
	public int getLaptop_rom() {
		return laptop_rom;
	}
	public void setLaptop_rom(int laptop_rom) {
		this.laptop_rom = laptop_rom;
	}
	public int getLaptop_processor() {
		return laptop_processor;
	}
	public void setLaptop_processor(int laptop_processor) {
		this.laptop_processor = laptop_processor;
	}
	public String getLaptop_os() {
		return laptop_os;
	}
	public void setLaptop_os(String laptop_os) {
		this.laptop_os = laptop_os;
	}
	public int getLaptop_weight() {
		return laptop_weight;
	}
	public void setLaptop_weight(int laptop_weight) {
		this.laptop_weight = laptop_weight;
	}
	public int getLaptop_size() {
		return laptop_size;
	}
	public void setLaptop_size(int laptop_size) {
		this.laptop_size = laptop_size;
	}
	public int getLaptop_graphic_card() {
		return laptop_graphic_card;
	}
	public void setLaptop_graphic_card(int laptop_graphic_card) {
		this.laptop_graphic_card = laptop_graphic_card;
	}
    
    
}
