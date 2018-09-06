package ecommerce.database;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ecommerce.database.dao.CustomerDaoService;
import ecommerce.database.dao.SubCategoryDaoService;
import ecommerce.database.dao.VendorAccountDaoService;
import ecommerce.database.dao.VendorAddressDaoService;
import ecommerce.database.dao.VendorDaoService;
import ecommerce.database.dao.admin.AdminDao;
import ecommerce.database.dao.products.LaptopDaoService;
import ecommerce.database.dao.products.MobileDaoService;
import ecommerce.database.model.Customer;
import ecommerce.database.model.Product;
import ecommerce.database.model.SubCategory;
import ecommerce.database.model.Vendor;
import ecommerce.database.model.VendorAccountDetails;
import ecommerce.database.model.VendorAddress;
import ecommerce.database.model.admin.Admin;
import ecommerce.database.model.products.Laptop;
import ecommerce.database.model.products.Mobile;

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
	private Admin admin;
    
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
	@Autowired
	private AdminDao adminDao;
	
	@Before
	public void setUp()
	{
		AnnotationConfigApplicationContext annotationConfigApplicationContext= new AnnotationConfigApplicationContext(PersistenceConfig.class);
	   vendor=new Vendor();
	   vendor.setCompany_name("Nikhils Boutique");
	   vendor.setVendor_name("Nikhil chandra");
	   vendor.setVendor_mobile("8909768");
	   vendor.setVendor_email("nikhilcg8@gmail.com");
	   vendor.setVendor_password("12345");
	   
	   
	   vendorAddress=new VendorAddress();
	   vendorAddress.setCity("hyderabad");
	   vendorAddress.setColony("Raghavendra nagar");
	   vendorAddress.setDoorNo("18-8-444/1/36");
	   vendorAddress.setLandmark("near jhanda");
	   vendorAddress.setState("Telengana State");
	   vendorAddress.setStreet("rss");
	   vendorAddress.setVendor(vendor);
	   
	   HashSet<VendorAddress> addresses=new HashSet<VendorAddress>();
	   addresses.add(vendorAddress);
	   
	   vendor.setAddresses(addresses);
	   
		  
	  vendorAccountDetails=new VendorAccountDetails();
	  vendorAccountDetails.setAccount_number("123456");
	  vendorAccountDetails.setBank_name("SBI");
	  vendorAccountDetails.setBranch("Barkas");
	  vendorAccountDetails.setName_in_account("Nikhil");
	  vendorAccountDetails.setVendor(vendor);
	  
	  HashSet<VendorAccountDetails> accountDetails=new HashSet<VendorAccountDetails>();
	  accountDetails.add(vendorAccountDetails);
	  
	  vendor.setAccountDetails(accountDetails);
	

	 
	  laptop=new Laptop();
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
	  laptop.setVendor(vendor);
	  
	  
	  List<Product> products=new ArrayList<>();
	  products.add(laptop);
	  
	  vendor.setProducts(products);
	  
	  admin.setEmail("admin@gmail.com");
	  admin.setPassword("@12345");
	 
	}
	
	@Test
	public void addAdmin()
	{
		assertEquals("Test add admin Failed",true,adminDao.addAdmin(admin));
		deleteAdmin();
	}

	@Test
	public void addCustomer()
	{
		//vendorDaoService.addVendor(vendor);
		
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
	    assertEquals("Test getVendor Failed",vendor,vendorDaoService.getVendorByEmail(vendor.getVendor_email()));
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
		//System.out.println(vendorAddress.getAddress_id());
		VendorAddress vendorAddress1=new VendorAddress();
		vendorAddress1.setLandmark("Hospital");
		assertEquals("Test Vendor Address Insertion Failed",true,vendorAddressDaoService.addVendorAddress(vendorAddress1));
		vendorAddressDaoService.deleteVendorAddress(vendorAddress1);
	}
	
	
	@Test
	public void getVendorAddress()
	{
		vendorDaoService.addVendor(vendor);
		long address_id=vendorAddress.getAddress_id();
		assertEquals("Test Vendor Address retrieval failed",vendorAddress,vendorAddressDaoService.getVendorAddress(address_id));
	
	}
	
	@Test
	public void updateVendorAddress()
	{
		vendorDaoService.addVendor(vendor);
		assertEquals("Test Vendor Address Update Failed",true,vendorAddressDaoService.editVendorAddress(vendorAddress));
		
	}
	
	
	@Test
	public void addVendorAccount()
	{
		   vendorDaoService.addVendor(vendor);
		   VendorAccountDetails accountDetails=new VendorAccountDetails();
		   accountDetails.setAccount_number("86896545");
		   accountDetails.setBranch("kachiguda");
		   //assertEquals("updating testing",true,vendorAccountDaoService.editVendorAccount(vendorAccountDetails));
		   assertEquals("testAddVendorAccount",true,vendorAccountDaoService.addVendorAccount(accountDetails));
		   vendorAccountDaoService.deleteVendorAccount(accountDetails);
		   
		   
	}
	
	
	@Test
	public void updateVendorAccount()
	{
		vendorDaoService.addVendor(vendor);
		Set<VendorAccountDetails> accountDetails=vendor.getAccountDetails();
		VendorAccountDetails vendorAccountDetails=accountDetails.iterator().next();
		vendorAccountDetails.setBranch("Hyderguda");
		assertEquals("Test Vendor Account updation failed",true,vendorAccountDaoService.editVendorAccount(vendorAccountDetails));
	}
	
	@Test
	public void getVendorAccount()
	{
		vendorDaoService.addVendor(vendor);
		long account_id=vendorAccountDetails.getAccount_id();
		assertEquals("Test Vendor Account Retrieval failed",vendorAccountDetails,vendorAccountDaoService.getVendorAccountById(account_id));
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
		if(vendorDaoService.getVendorById(vendor.getVendor_id())!=null)
		{
			vendorDaoService.deleteVendor(vendor);
		}
		
		
		
	}
	
	public void deleteAdmin()
	{
		if(adminDao.adminLogin(admin.getEmail(),admin.getPassword())!=null)
		{
			adminDao.deleteAdmin(admin);
		}
	}
	
	public void deleteVendorAddress()
	{
		if(vendorAddressDaoService.getVendorAddress(vendorAddress.getAddress_id())!=null)
		{
			vendorAddressDaoService.deleteVendorAddress(vendorAddress);
		}
			
	}
	
	public void deleteVendorAccount()
	{
		if(vendorAccountDaoService.getVendorAccountById(vendorAccountDetails.getAccount_id())!=null)
		{
			vendorAccountDaoService.deleteVendorAccount(vendorAccountDetails);
		}
		
	}
	
	public void deleteLaptop()
	{
		if(laptopDaoService.retrieveLaptopById(laptop.getProductId())!=null)
		{
			laptopDaoService.deleteLaptop(laptop);
		}
		
	}
	
	public void deleteCustomer()
	{
		if(customerDaoService.getCustomerById(customer.getCustomer_id())!=null)
		{
			customerDaoService.deleteCustomer(customer);
		}
		
	}
	
	
/*	
	@Test
	public void testGetUser()
	{
		vendorDaoService.addVendor(vendor);
		System.out.println(vendorDaoService.getVendorById(vendor.getVendor_id()));
	}
	*/
	
}
