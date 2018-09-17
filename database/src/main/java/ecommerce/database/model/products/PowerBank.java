package ecommerce.database.model.products;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

import ecommerce.database.model.Product;

@Entity
@Component("PowerBank")
public class PowerBank extends Product{
	
	private String batteryType;
	private byte numberOFOutputs;
	private byte powerOutput;
	
	public String getBatteryType() {
		return batteryType;
	}
	public void setBatteryType(String batteryType) {
		this.batteryType = batteryType;
	}
	public byte getNumberOFOutputs() {
		return numberOFOutputs;
	}
	public void setNumberOFOutputs(byte numberOFOutputs) {
		this.numberOFOutputs = numberOFOutputs;
	}
	public byte getPowerOutput() {
		return powerOutput;
	}
	public void setPowerOutput(byte powerOutput) {
		this.powerOutput = powerOutput;
	}
	
	
	

}
