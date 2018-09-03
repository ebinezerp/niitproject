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

import ecommerce.database.dao.CustomerDaoService;
import ecommerce.database.dao.VendorDaoService;
import ecommerce.database.model.Customer;
import ecommerce.database.model.Vendor;

@SpringJUnitConfig(classes = {PersistenceConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DemoTest {

	@Autowired
	private Vendor vendor;
	@Autowired
	private VendorDaoService vendorDaoService;
	
	@Autowired
	private Customer customer;
	@Autowired
	private CustomerDaoService customerDaoService;
	
	
	@Before
	public void setUp()
	{
		AnnotationConfigApplicationContext annotationConfigApplicationContext= new AnnotationConfigApplicationContext(PersistenceConfig.class);
	   vendor.setCompany_name("Nikhils Boutique");
	   vendor.setVendor_name("Nikhil chandra");
	   vendor.setVendor_mobile("8909768");
	   vendor.setVendor_email("nikhilcg8@gmail.com");
	   vendor.setVendor_password("12345");
	   
	   
	      customer.setCustomer_name("akhil");
		  customer.setCustomer_email("akhil@gmail.com");
		  customer.setCustomer_mobile("098765422");
		  customer.setCustomer_password("@12345");
	}
	
	@Test
	public void addVendor()
	{
		 assertEquals("Test Vendor Insertion Failed",true,vendorDaoService.addVendor(vendor));
		 System.out.println(vendor.getVendor_id());
	}
	
	@Test
	public void addCustomer()
	{
		assertEquals("Test Adding customer failed",true,customerDaoService.addCustomer(customer));
	}
	
	
	@After
	public void deleteAll()
	{
		if(vendorDaoService.getVendorById(vendor.getVendor_id())!=null)
		{
			vendorDaoService.deleteVendor(vendor);
		}
		
		if(customerDaoService.getCustomerById(customer.getCustomer_id())!=null)
		{
			customerDaoService.deleteCustomer(customer);
		}
	}
	
	
}