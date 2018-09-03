package ecommerce.database;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ecommerce.database.dao.CustomerAccountDaoService;
import ecommerce.database.dao.CustomerAddressDaoService;
import ecommerce.database.dao.CustomerDaoService;
import ecommerce.database.model.Customer;
import ecommerce.database.model.CustomerAccount;
import ecommerce.database.model.CustomerAddress;

@SpringJUnitConfig(classes = {PersistenceConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerAppTest {

	@Autowired
	private Customer customer;
	@Autowired
	private CustomerDaoService customerDaoService;
	
	@Autowired
	private CustomerAddress customerAddress;
	@Autowired
	private CustomerAddressDaoService customerAddressDaoService;
	
	@Autowired
	private CustomerAccount customerAccount;
	@Autowired
	private CustomerAccountDaoService customerAccountDaoService;
	
	@Before
	public void setUp()
	{
		AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext(PersistenceConfig.class);
		
		  customer.setCustomer_name("akhil");
		  customer.setCustomer_email("akhil@gmail.com");
		  customer.setCustomer_mobile("098765422");
		  customer.setCustomer_password("@12345");
		  
		  
		  customerAddress.setCity("Hyderabad");
		  customerAddress.setColony("Raghavendra nagar");
		  customerAddress.setDoor_no("18-8-444/1/36");
		  customerAddress.setLandmark("Jhanda");
		  customerAddress.setPincode("500053");
		  customerAddress.setStreet("Rss");
		  customerAddress.setState("Telangana state");
		  
		  
		  customerAccount.setAccount_number("12345678");
		  customerAccount.setBank_name("Bank Of baroda");
		  customerAccount.setBranch("Baroda");
		  customerAccount.setName_in_account("Akhil kumar");
	}
	
	
	@Test
	public void addCustomer()
	{
		assertEquals("Test Adding customer failed",true,customerDaoService.addCustomer(customer));
	}
	
	@Test
	public void addCustomerAddress()
	{
		customerDaoService.addCustomer(customer);
		customerAddress.setCustomer(customer);
		assertEquals("Test addCustomerAddress failed",true,customerAddressDaoService.addCustomerAddress(customerAddress));
		deleteCustomerAddress();
	}
	
	@Test
	public void addCustomerAccount()
	{
		customerDaoService.addCustomer(customer);
		customerAccount.setCustomer(customer);
		assertEquals("Test addCustomerAccount failed",true,customerAccountDaoService.addCustomerAccount(customerAccount));
		deleteCustomerAccount();
	}
	
	@After
	public void deleteCustomer()
	{
		customerDaoService.deleteCustomer(customer);
	}
	
    public void deleteCustomerAddress()
    {
    	customerAddressDaoService.deleteCustomerAddress(customerAddress);
    }
    
    public void deleteCustomerAccount()
    {
    	customerAccountDaoService.deleteCustomerAccount(customerAccount);
    }
}
