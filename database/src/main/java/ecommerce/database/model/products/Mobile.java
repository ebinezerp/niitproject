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
@Component("Mobile")
public class Mobile extends Product{

	private int mobile_ram;
	private int mobile_rom;
	private boolean mobile_lte;
	private String mobile_os;
	private int mobile_weight;
	private byte mobile_display_size;
	private byte mobile_frontcam;
	private byte mobile_rearcam;
	private String mobile_description;
	
	public String getMobile_description() {
		return mobile_description;
	}
	public void setMobile_description(String mobile_description) {
		this.mobile_description = mobile_description;
	}
	public int getMobile_ram() {
		return mobile_ram;
	}
	public void setMobile_ram(int mobile_ram) {
		this.mobile_ram = mobile_ram;
	}
	public int getMobile_rom() {
		return mobile_rom;
	}
	public void setMobile_rom(int mobile_rom) {
		this.mobile_rom = mobile_rom;
	}
	public boolean isMobile_lte() {
		return mobile_lte;
	}
	public void setMobile_lte(boolean mobile_lte) {
		this.mobile_lte = mobile_lte;
	}
	public String getMobile_os() {
		return mobile_os;
	}
	public void setMobile_os(String mobile_os) {
		this.mobile_os = mobile_os;
	}
	public int getMobile_weight() {
		return mobile_weight;
	}
	public void setMobile_weight(int mobile_weight) {
		this.mobile_weight = mobile_weight;
	}
	public byte getMobile_display_size() {
		return mobile_display_size;
	}
	public void setMobile_display_size(byte mobile_display_size) {
		this.mobile_display_size = mobile_display_size;
	}
	public byte getMobile_frontcam() {
		return mobile_frontcam;
	}
	public void setMobile_frontcam(byte mobile_frontcam) {
		this.mobile_frontcam = mobile_frontcam;
	}
	public byte getMobile_rearcam() {
		return mobile_rearcam;
	}
	public void setMobile_rearcam(byte mobile_rearcam) {
		this.mobile_rearcam = mobile_rearcam;
	}
	
	
	

}
