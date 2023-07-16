/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: This Junit Test tests all the Management company methods.
 * Due: 07/13/2023
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here:Vivek Hubbly
*/
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ManagementCompanyTestStudent {
	private ManagementCompany managementCompany;
	@BeforeEach
	void setUp() throws Exception {
		managementCompany = new ManagementCompany("ABC Company", "123456789", 5.0);
	}

	@AfterEach
	void tearDown() throws Exception {
		managementCompany = null;
	}

	@Test
	void testManagementCompany() {
		assertEquals("ABC Company", managementCompany.getName());
		assertEquals("123456789", managementCompany.getTaxID());
		assertEquals(5.0, managementCompany.getMgmFeePer());
	}

	@Test
	void testAddPropertyProperty() {
		int index = managementCompany.addProperty("Property 1", "City 1", 1000.0, "Owner 1");
		assertEquals(0, index);
		assertEquals(1, managementCompany.getPropertiesCount());
		assertEquals(1000.0, managementCompany.getTotalRent());
	}

	@Test
	void testRemoveLastProperty() {
		managementCompany.addProperty("Property 1", "City 1", 1000.0, "Owner 1");
		managementCompany.addProperty("Property 2", "City 2", 2000.0, "Owner 2");
		managementCompany.removeLastProperty();
		
	}

	@Test
	void testIsPropertiesFull() {
assertFalse(managementCompany.isPropertiesFull());
		
		// Add 5 properties to reach the maximum capacity
		managementCompany.addProperty("Property 1", "City 1", 1000.0, "Owner 1");
		managementCompany.addProperty("Property 2", "City 2", 2000.0, "Owner 2");
		managementCompany.addProperty("Property 3", "City 3", 3000.0, "Owner 3");
		managementCompany.addProperty("Property 4", "City 4", 4000.0, "Owner 4");
		managementCompany.addProperty("Property 5", "City 5", 5000.0, "Owner 5");
		
		assertFalse(managementCompany.isPropertiesFull());
	}

	@Test
	void testGetPropertiesCount() {
		assertEquals(0, managementCompany.getPropertiesCount());
		
		managementCompany.addProperty("Property 1", "City 1", 1000.0, "Owner 1");
		managementCompany.addProperty("Property 2", "City 2", 2000.0, "Owner 2");
		
		assertEquals(1, managementCompany.getPropertiesCount());
	}

	@Test
	void testGetTotalRent() {
		managementCompany.addProperty("Property1", "City1", 1000.0, "Owner1");
        managementCompany.addProperty("Property2", "City2", 2000.0, "Owner2");
        assertEquals(1000.0, managementCompany.getTotalRent());
	}

	@Test
	void testGetHighestRentPropperty() {
		managementCompany.addProperty("Property1", "City1", 1000.0, "Owner1");
        managementCompany.addProperty("Property2", "City2", 2000.0, "Owner2");
        managementCompany.addProperty("Property3", "City3", 1500.0, "Owner3");
        assertEquals("Property1", managementCompany.getHighestRentPropperty().getPropertyName());
	}

	@Test
	void testIsMangementFeeValid() {
		assertTrue(managementCompany.isMangementFeeValid());
        managementCompany = new ManagementCompany("Company", "12345", -5.0);
        assertFalse(managementCompany.isMangementFeeValid());
        managementCompany = new ManagementCompany("Company", "12345", 105.0);
        assertFalse(managementCompany.isMangementFeeValid());
	}

	@Test
	void testGetName() {
		assertEquals("ABC Company", managementCompany.getName());
	}

	@Test
	void testGetTaxID() {
		assertEquals("123456789", managementCompany.getTaxID());
	}

	@Test
	void testGetProperties() {
		managementCompany.addProperty("Property1", "City1", 1000.0, "Owner1");
        managementCompany.addProperty("Property2", "City2", 2000.0, "Owner2");
        
	}

	@Test
	void testGetMgmFeePer() {
		assertEquals(5.0, managementCompany.getMgmFeePer());
	}

	@Test
	void testGetPlot() {
		assertEquals(10, managementCompany.getPlot().getWidth());
        assertEquals(10, managementCompany.getPlot().getDepth());
	}

	@Test
	void testToString() {
		managementCompany.addProperty("Property1", " City1", 1000.0, " Owner1");
        String expected = "Management Company: ABC Company (Tax ID: 123456789)\n" + "Properties:\n" + "Property1, City1, Owner1,1000.0\n";
                      
        assertEquals(expected, managementCompany.toString());
    }
	
}
