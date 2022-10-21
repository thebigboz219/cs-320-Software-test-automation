package Mobile_application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;		This line would not work with the test runner.
import org.junit.Test;

public class ContactTest {
	
	@Test
	public void testContactCreation() {
		
		Contact test1 = new Contact("13485702", "Jacob", "McPherson", "2038501193", "random-name@gmail.com");
		assertTrue(test1.getContactID().equals("13485702"));
		System.out.println("Contact " + test1.getContactID() + " successfully created");
	}
	
	@Test
	public void testContactGets() {
		
		Contact test1 = new Contact("130943", "John", "Wick", "9728104917", "Middle O' Nowhere");
		
		assertTrue(test1.getContactID().equals("130943"));
		assertTrue(test1.getFirstName().equals("John"));
		assertTrue(test1.getLastName().equals("Wick"));
		assertTrue(test1.getPhone().equals("9728104917"));
		assertTrue(test1.getAddress().equals("Middle O' Nowhere"));
		System.out.println("Get methods tested");
	}
	
	@Test
	public void testContactSets() {
		
		Contact test1 = new Contact("1045802", "Larry", "Lobster", "0198385018", "Bikini Bottom");
		
		assertTrue(test1.getFirstName().equals("Larry"));
		test1.setFirstName("Patrick");
		test1.setLastName("Star");
		test1.setPhone("1111111111");
		test1.setAddress("under the largest rock");
		assertTrue(test1.getFirstName().equals("Patrick"));
		assertTrue(test1.getLastName().equals("Star"));
		assertTrue(test1.getPhone().equals("1111111111"));
		assertTrue(test1.getAddress().equals("under the largest rock"));
	}
	
	@Test
	public void testContactIDLongError() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("13094311111", "John", "Wick", "9728104917", "Middle O' Nowhere");
		});
	}
	
	@Test
	public void testContactIDNullError() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("", "John", "Wick", "9728104917", "Middle O' Nowhere");
		});
	}
	
	@Test
	public void testFirstNameLongError() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("130943", "John is a legend", "Wick", "9728104917", "Middle O' Nowhere");
		});
	}
	
	@Test
	public void testFirstNameNullError() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("130943", "", "Wick", "9728104917", "Middle O' Nowhere");
		});
	}
	
	@Test
	public void testLastNameLongError() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("130943", "John", "Wick it like its hot", "9728104917", "Middle O' Nowhere");
		});
	}
	
	@Test
	public void testLastNameNullError() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("130943", "John", "", "9728104917", "Middle O' Nowhere");
		});
	}
	
	@Test
	public void testPhoneLongError() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("130943", "John", "Wick", "9728104917123", "Middle O' Nowhere");
		});
	}
	
	@Test
	public void testPhoneNullError() {

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("130943", "John", "Wick", "", "Middle O' Nowhere");
		});
	}
	
	@Test
	public void testAddressLongError() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("130943", "John", "Wick", "9728104917", "Middle O' Nowhere in the middle of kansas");
		});
	}
	
	@Test
	public void testAddressNullError() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("130943", "John", "Wick", "9728104917", "");
		});
	}
	

}
