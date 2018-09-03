package ecommerce.database.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Entity
@Component("CustomerAccount")
public class CustomerAccount {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long account_id;
	@Column(nullable=false)
	private String name_in_account;
	@Column(nullable=false)
	private String bank_name;
	@Column(nullable=false)
	private String branch;
	@Column(unique=true,nullable=false)
	private String account_number;

	@ManyToOne
	private Customer customer;

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

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
	
}
