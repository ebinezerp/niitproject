package ecommerce.database.model.order;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.springframework.stereotype.Component;

import ecommerce.database.model.Customer;

@Entity
@Component("Order")
@Table(name="ordertable")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long orderId;
	private int noOfItems;
	private int netPrice;
	@ManyToOne
	private Customer customer;
	@OneToMany(mappedBy="order",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<OrderedItems> orderedItemsList;
	private Date date;
	private Timestamp timestamp;
	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getOrderId() {
		return orderId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public List<OrderedItems> getOrderedItemsList() {
		return orderedItemsList;
	}
	public void setOrderedItemsList(List<OrderedItems> orderedItemsList) {
		this.orderedItemsList = orderedItemsList;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public int getNoOfItems() {
		return noOfItems;
	}
	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}
	public int getNetPrice() {
		return netPrice;
	}
	public void setNetPrice(int netPrice) {
		this.netPrice = netPrice;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	

}
