package ecommerce.database.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

@Entity
@Component("VendorAccount")
public class VendorAccountDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long account_id;
	private String name_in_account;
	private String bank_name;
	@Column(unique=true)
	private String account_number;
    private String branch;
	
	@ManyToOne
	private Vendor vendor;

	public long getAccount_id() {
		return account_id;
	}

	public void setAccount_id(long account_id) {
		this.account_id = account_id;
	}

	public String getName_in_account() {
		return name_in_account;
	}

	public void setName_in_account(String name_in_account) {
		this.name_in_account = name_in_account;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account_number == null) ? 0 : account_number.hashCode());
		result = prime * result + ((bank_name == null) ? 0 : bank_name.hashCode());
		result = prime * result + ((branch == null) ? 0 : branch.hashCode());
		result = prime * result + ((name_in_account == null) ? 0 : name_in_account.hashCode());
		result = prime * result + ((vendor == null) ? 0 : vendor.hashCode());
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
		VendorAccountDetails other = (VendorAccountDetails) obj;
		if (account_number == null) {
			if (other.account_number != null)
				return false;
		} else if (!account_number.equals(other.account_number))
			return false;
		if (bank_name == null) {
			if (other.bank_name != null)
				return false;
		} else if (!bank_name.equals(other.bank_name))
			return false;
		if (branch == null) {
			if (other.branch != null)
				return false;
		} else if (!branch.equals(other.branch))
			return false;
		if (name_in_account == null) {
			if (other.name_in_account != null)
				return false;
		} else if (!name_in_account.equals(other.name_in_account))
			return false;
		if (vendor == null) {
			if (other.vendor != null)
				return false;
		} else if (!vendor.equals(other.vendor))
			return false;
		return true;
	}


	
	
	

	

}
