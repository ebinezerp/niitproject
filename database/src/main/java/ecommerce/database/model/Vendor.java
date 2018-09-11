package ecommerce.database.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.OnDelete;
import org.springframework.stereotype.Component;

import ecommerce.database.model.products.AirConditioner;
import ecommerce.database.model.products.Laptop;
import ecommerce.database.model.products.Mobile;
import ecommerce.database.model.products.Refrigerator;
import ecommerce.database.model.products.Television;

@Entity
@Component("Vendor")
public class Vendor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long vendor_id;
	
	@NotNull(message="Name should not be null")
	@NotBlank(message="Name should not be blank")
	@Pattern(regexp="[a-zA-Z0-9]{5,15}",message="Name Should be minimum of 5 and maximum of 15 characters")
	private String vendor_name;
	
	@Column(nullable=false)
	private int verificationCode;
	
	private boolean emailverified;
	
	
	@NotNull(message="Email should not be null")
	@NotBlank(message="Email should not be blank")
	@Pattern(regexp="[^A-Z]{4,25}@.{4,10}\\..{2,5}",message="Email should contain atleast 4 characters before @")
	@Column(unique=true)
	private String vendor_email;
	
	@NotNull(message="Password should not be null")
	@NotBlank(message="Password should not be blank")
	private String vendor_password;
	
	@Pattern(regexp="^[6-9]\\d{9}",message="mobile should start with 6/7/8/9 and there must be 10 numbers")
	@Column(unique=true)
	private String vendor_mobile;
	
	@NotNull(message="Company name should not be null")
	@NotBlank(message="Company name should not be blank")
	@Column(unique=true)
    private String company_name;
	private boolean vendor_active;
    
   
	@OneToMany(mappedBy="vendor",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
    private Set<VendorAddress> addresses;
    
	@OneToMany(mappedBy="vendor",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
    private Set<VendorAccountDetails> accountDetails;
	
	@OneToMany(mappedBy="vendor",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<Product> products;
	
	public long getVendor_id() {
		return vendor_id;
	}

	public boolean isEmailverified() {
		return emailverified;
	}

	public void setEmailverified(boolean emailverified) {
		this.emailverified = emailverified;
	}
	
	public int getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(int verificationCode) {
		this.verificationCode = verificationCode;
	}
	
	 public boolean getVendor_active() {
			return vendor_active;
		}
		public void setVendor_active(boolean vendor_active) {
			this.vendor_active = vendor_active;
		}
		
	public Set<VendorAddress> getAddresses() {
		return addresses;
	}
	public void setAddresses(Set<VendorAddress> addresses) {
		this.addresses = addresses;
	}
	public Set<VendorAccountDetails> getAccountDetails() {
		return accountDetails;
	}
	public void setAccountDetails(Set<VendorAccountDetails> accountDetails) {
		this.accountDetails = accountDetails;
	}
	
	public void setVendor_id(long vendor_id) {
		this.vendor_id = vendor_id;
	}
	public String getVendor_name() {
		return vendor_name;
	}
	public void setVendor_name(String vendor_name) {
		this.vendor_name = vendor_name;
	}
	public String getVendor_email() {
		return vendor_email;
	}
	public void setVendor_email(String vendor_email) {
		this.vendor_email = vendor_email;
	}
	public String getVendor_password() {
		return vendor_password;
	}
	public void setVendor_password(String vendor_password) {
		this.vendor_password = vendor_password;
	}
	public String getVendor_mobile() {
		return vendor_mobile;
	}
	public void setVendor_mobile(String vendor_mobile) {
		this.vendor_mobile = vendor_mobile;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	
	
    
	  public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	@Override
		public String toString() {
			return "Vendor [vendor_id=" + vendor_id + ", vendor_name=" + vendor_name + ", vendor_email=" + vendor_email
					+ ", vendor_password=" + vendor_password + ", vendor_mobile=" + vendor_mobile + ", company_name="
					+ company_name + ", Addresses=" + addresses + ", accountDetails=" + accountDetails + "]";
		}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((company_name == null) ? 0 : company_name.hashCode());
		result = prime * result + ((vendor_email == null) ? 0 : vendor_email.hashCode());
		result = prime * result + ((vendor_mobile == null) ? 0 : vendor_mobile.hashCode());
		result = prime * result + ((vendor_name == null) ? 0 : vendor_name.hashCode());
		result = prime * result + ((vendor_password == null) ? 0 : vendor_password.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendor other = (Vendor) obj;
		if (company_name == null) {
			if (other.company_name != null)
				return false;
		} else if (!company_name.equals(other.company_name))
			return false;
		if (vendor_email == null) {
			if (other.vendor_email != null)
				return false;
		} else if (!vendor_email.equals(other.vendor_email))
			return false;
		if (vendor_mobile == null) {
			if (other.vendor_mobile != null)
				return false;
		} else if (!vendor_mobile.equals(other.vendor_mobile))
			return false;
		if (vendor_name == null) {
			if (other.vendor_name != null)
				return false;
		} else if (!vendor_name.equals(other.vendor_name))
			return false;
		if (vendor_password == null) {
			if (other.vendor_password != null)
				return false;
		} else if (!vendor_password.equals(other.vendor_password))
			return false;
		return true;
	}

	  
	  
	  

	
}
