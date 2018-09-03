package ecommerce.database;


import static org.junit.Assert.assertEquals;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ecommerce.database.dao.CategoryDaoService;
import ecommerce.database.dao.CustomerDaoService;
import ecommerce.database.dao.ProductDaoService;
import ecommerce.database.dao.SubCategoryDaoService;
import ecommerce.database.dao.VendorAccountDaoService;
import ecommerce.database.dao.VendorAddressDaoService;
import ecommerce.database.dao.VendorDaoService;
import ecommerce.database.dao.products.LaptopDaoService;
import ecommerce.database.dao.products.MobileDaoService;
import ecommerce.database.daoImpl.VendorDaoImpl;
import ecommerce.database.model.VendorAddress;
import ecommerce.database.model.products.Laptop;
import ecommerce.database.model.products.Mobile;
import ecommerce.database.model.Category;
import ecommerce.database.model.Customer;
import ecommerce.database.model.Product;
import ecommerce.database.model.SubCategory;
import ecommerce.database.model.Vendor;
import ecommerce.database.model.VendorAccountDetails;

/**
 * Unit test for simple App.
 */
@SpringJUnitConfig(classes = {PersistenceConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AppTest {
	
	@Autowired
    private	Vendor vendor;
	@Autowired
	private VendorAddress vendorAddress;
	@Autowired
	private VendorAccountDetails vendorAccountDetails;
	@Autowired
	private Laptop laptop;
	@Autowired
	private SubCategory subCategory;
	@Autowired
	private Mobile mobile;
    @Autowired
	private Customer customer;
	
	@Autowired
	private VendorDaoService vendorDaoService;
	@Autowired
	private VendorAddressDaoService vendorAddressDaoService;
    @Autowired
	private VendorAccountDaoService vendorAccountDaoService;
	@Autowired
    private LaptopDaoService laptopDaoService;
	@Autowired
	private SubCategoryDaoService subCategoryDaoService;
	@Autowired
	private MobileDaoService mobileDaoService;
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
	
	   vendorAddress.setCity("hyderabad");
	   vendorAddress.setColony("Raghavendra nagar");
	   vendorAddress.setDoorNo("18-8-444/1/36");
	   vendorAddress.setLandmark("near jhanda");
	   vendorAddress.setState("Telengana State");
	   vendorAddress.setStreet("rss");
	  
	   
		  
	   
	  vendorAccountDetails.setAccount_number("123456");
	  vendorAccountDetails.setBank_name("SBI");
	  vendorAccountDetails.setBranch("Barkas");
	  vendorAccountDetails.setName_in_account("Nikhil");
	  vendorAccountDetails.setVendor(vendor);
	

	 
	  
	  laptop.setProduct_brand("Dell");
	  laptop.setProduct_model("Inspiron 3000");
	  short warranty=10;
	  laptop.setWarrantyInMonths(warranty);
	  laptop.setProduct_color("Black");
	  laptop.setLaptop_weight(1200);
	  laptop.setLaptop_size(12);
	  laptop.setLaptop_rom(400);
	  laptop.setLaptop_ram(4);
	  laptop.setLaptop_processor(8);
	  laptop.setLaptop_os("Windows 10");
	  laptop.setLaptop_graphic_card(100);
	  laptop.setLaptop_description("This is my lappy");
	  
	  
	 
	}

	@Test
	public void addCustomer()
	{
		vendorDaoService.addVendor(vendor);
		
		customer.setCustomer_name("akhil");
		  customer.setCustomer_email("akhil@gmail.com");
		  customer.setCustomer_mobile("098765422");
		  customer.setCustomer_password("@12345");
		assertEquals("Test Adding customer failed",true,customerDaoService.addCustomer(customer));
	    deleteCustomer();
	}
	
	@Test
	public void addVendor()
	{
	   assertEquals("Test Vendor Insertion Failed",true,vendorDaoService.addVendor(vendor));
	}	
	
    @Test
	public void getVendor()
	{
	    vendorDaoService.addVendor(vendor);
	    vendorAccountDetails.setVendor(vendor);
	    vendorAddress.setVendor(vendor);
	    vendorAddressDaoService.addVendorAddress(vendorAddress);
	    vendorAccountDaoService.addVendorAccount(vendorAccountDetails);	    
	    long vendor_id=vendor.getVendor_id();
	    assertEquals("Test Vendor Retrieval failed",vendor,vendorDaoService.getVendorById(vendor_id));
	    deleteVendorAccount();
	    deleteVendorAddress();
	}
	@Test
	public void updateVendor()
	{
		vendorDaoService.addVendor(vendor);
		vendor.setVendor_name("raghu");
		assertEquals("Test Vendor Updation Failed",true,vendorDaoService.editVendor(vendor));
	}
	
	@Test
	public void addVendorAddress()
	{
		vendorDaoService.addVendor(vendor);
		 vendorAddress.setVendor(vendor);
		assertEquals("Test Vendor Address Insertion Failed",true,vendorAddressDaoService.addVendorAddress(vendorAddress));
		deleteVendorAddress();
	}
	
	@Test
	public void getVendorAddress()
	{
		vendorDaoService.addVendor(vendor);
		vendorAddressDaoService.addVendorAddress(vendorAddress);
		long address_id=vendorAddress.getAddress_id();
		assertEquals("Test Vendor Address retrieval failed",vendorAddress,vendorAddressDaoService.getVendorAddress(address_id));
		deleteVendorAddress();
	}
	
	@Test
	public void updateVendorAddress()
	{
		vendorDaoService.addVendor(vendor);
		vendorAddressDaoService.addVendorAddress(vendorAddress);
		assertEquals("Test Vendor Address Update Failed",true,vendorAddressDaoService.editVendorAddress(vendorAddress));
		deleteVendorAddress();
	}
	
	
	@Test
	public void addVendorAccount()
	{
		vendorDaoService.addVendor(vendor);
		assertEquals("Test add Vendor Account Failed",true,vendorAccountDaoService.addVendorAccount(vendorAccountDetails));
		deleteVendorAccount();
	}
	
	@Test
	public void updateVendorAccount()
	{
		vendorDaoService.addVendor(vendor);
		vendorAccountDetails.setVendor(vendor);
		vendorAccountDaoService.addVendorAccount(vendorAccountDetails);
		assertEquals("Test Vendor Account updation failed",true,vendorAccountDaoService.editVendorAccount(vendorAccountDetails));
        deleteVendorAccount();
	}
	
	@Test
	public void getVendorAccount()
	{
		vendorDaoService.addVendor(vendor);
		vendorAccountDetails.setVendor(vendor);
		vendorAccountDaoService.addVendorAccount(vendorAccountDetails);
		long account_id=vendorAccountDetails.getAccount_id();
		assertEquals("Test Vendor Account Retrieval failed",vendorAccountDetails,vendorAccountDaoService.getVendorAccountById(account_id));
		deleteVendorAccount();
	}
	
	@Test
	public void addLaptop()
	{
		
		subCategory=subCategoryDaoService.getSubCategory(1);
		
	
		vendorDaoService.addVendor(vendor);
		laptop.setVendor(vendor);
		laptop.setSubCategory(subCategory);
		assertEquals("Test Insertion laptop failed",true,laptopDaoService.addLaptop(laptop));
		deleteLaptop();
	
	}
	

	
   
	@After
	public void deleteAll()
	{
		
		
		assertEquals("Test Delete Vendor Failed",true,vendorDaoService.deleteVendor(vendor));	
		
	}
	
	public void deleteVendorAddress()
	{
		vendorAddressDaoService.deleteVendorAddress(vendorAddress);	
	}
	
	public void deleteVendorAccount()
	{
		vendorAccountDaoService.deleteVendorAccount(vendorAccountDetails);
	}
	
	public void deleteLaptop()
	{
		laptopDaoService.deleteLaptop(laptop);
	}
	
	public void deleteCustomer()
	{
		customerDaoService.deleteCustomer(customer);
	}
	
	
}
