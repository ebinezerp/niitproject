package ecommerce.database.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.omg.CORBA.Principal;
import org.springframework.stereotype.Component;

@Entity
@Component("Customer")
public class Customer{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long customer_id;
	@Column(nullable=false)
	private String customer_name;
	@Column(unique=true,nullable=false)
	private String customer_mobile;
	@Column(unique=true,nullable=false)
	private String customer_email;
	@Column(nullable=false)
	private String customer_password;

	private boolean active=true;
	
	private final String role="customer";
	
	@OneToMany(mappedBy="customer")
	private Set<CustomerAddress> addresses;
	
	@OneToMany(mappedBy="customer")
	private Set<CustomerAccount> accounts;
	
	public long getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getCustomer_mobile() {
		return customer_mobile;
	}
	public void setCustomer_mobile(String customer_mobile) {
		this.customer_mobile = customer_mobile;
	}
	public String getCustomer_email() {
		return customer_email;
	}
	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}
	public String getCustomer_password() {
		return customer_password;
	}
	public void setCustomer_password(String customer_password) {
		this.customer_password = customer_password;
	}
	public Set<CustomerAddress> getAddresses() {
		return addresses;
	}
	public void setAddresses(Set<CustomerAddress> addresses) {
		this.addresses = addresses;
	}
	public Set<CustomerAccount> getAccounts() {
		return accounts;
	}
	public void setAccounts(Set<CustomerAccount> accounts) {
		this.accounts = accounts;
	}
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getRole() {
		return role;
	}
}
