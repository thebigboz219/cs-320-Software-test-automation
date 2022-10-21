package Mobile_application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;		This line would not work with the test runner.
import org.junit.Test;

public class ContactServiceTest {

	@Test
	public void testAddContact() {
		ContactService cs = new ContactService();
		Contact test1 = new Contact("12329487", "Bob", "Marley", "2140388437", "214 Rando Ln");
		Contact test2 = new Contact("12138403", "Bruce", "Wayne", "2301740593", "Batcave Cherry Dr");
		assertTrue(cs.addContact(test1));
		assertTrue(cs.addContact(test2));
	}
	
	@Test
	public void testAddContactDuplicate() {
		
		ContactService cs = new ContactService();
		Contact test1 = new Contact("12345678", "Bob", "Marley", "2140388437", "214 Rando Ln");
		Contact test2 = new Contact("12345678", "Bruce", "Wayne", "2301740593", "Batcave Cherry Dr");
		assertTrue(cs.addContact(test1));
		assertFalse(cs.addContact(test2));
	}
	
	@Test
	public void testDeleteContact() {
		
		ContactService cs = new ContactService();
		
		Contact test1 = new Contact("130943", "John", "Wick", "9728104917", "Middle O' Nowhere");
		Contact test2 = new Contact("10346854", "Bruce", "Wayne", "2301740593", "Batcave Cherry Dr");
		Contact test3 = new Contact("2971479", "Snoop", "Dogg", "1384034817", "Malibu Beach");
		
		assertTrue(cs.addContact(test1));
		assertTrue(cs.addContact(test2));
		assertTrue(cs.addContact(test3));
		
		assertTrue(cs.deleteContact("130943"));
		assertTrue(cs.deleteContact("10346854"));
	}
	
	@Test
	public void testDeleteContactDuplicate() {
		
		ContactService cs = new ContactService();
		
		Contact test1 = new Contact("130943", "John", "Wick", "9728104917", "Middle O' Nowhere");
		Contact test2 = new Contact("10346854", "Bruce", "Wayne", "2301740593", "Batcave Cherry Dr");
		Contact test3 = new Contact("2971479", "Snoop", "Dogg", "1384034817", "Malibu Beach");
		
		assertTrue(cs.addContact(test1));
		assertTrue(cs.addContact(test2));
		assertTrue(cs.addContact(test3));
		
		assertTrue(cs.deleteContact("130943"));
		assertFalse(cs.deleteContact("130943"));
	}
	
	@Test
	public void testUpdateContact() {
		
		ContactService cs = new ContactService();
		
		Contact test1 = new Contact("130943", "John", "Wick", "9728104917", "Middle O' Nowhere");
		Contact test2 = new Contact("10346854", "Bruce", "Wayne", "2301740593", "Batcave Cherry Dr");
		Contact test3 = new Contact("2971479", "Snoop", "Dogg", "1384034817", "Malibu Beach");
		
		assertTrue(cs.addContact(test1));
		assertTrue(cs.addContact(test2));
		assertTrue(cs.addContact(test3));
		
		assertTrue(cs.updateContact("130943",  "John", "Williams", "9728104917", "Middle O' Nowhere"));
		assertTrue(cs.updateContact("10346854", "Robin", "Hood", "2301740593", "Holly hills England"));
	}
	
	@Test
	public void testUpdateContactLongErrors() {
		
		ContactService cs = new ContactService();
		
		Contact test1 = new Contact("130943", "John", "Wick", "9728104917", "Middle O' Nowhere");
		Contact test2 = new Contact("10346854", "Bruce", "Wayne", "2301740593", "Batcave Cherry Dr");
		Contact test3 = new Contact("2971479", "Snoop", "Dogg", "1384034817", "Malibu Beach");
		
		assertTrue(cs.addContact(test1));
		assertTrue(cs.addContact(test2));
		assertTrue(cs.addContact(test3));
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			cs.updateContact("130943", "Johnny my boy", "Wick", "9728104917", "Middle O' Nowhere");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			cs.updateContact("10346854", "Bruce", "Wayne is a doofus", "2301740593", "Batcave Cherry Dr");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			cs.updateContact("2971479", "Snoop", "Dogg", "1340501341613", "Malibu Beach");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			cs.updateContact("130943", "John", "Wick", "9728104917", "Absolutely in the middle of nowhere kansas with dirt");
		});
		
	}
	
	@Test
	public void testUpdateContactNullErrors() {
		
		ContactService cs = new ContactService();
		
		Contact test1 = new Contact("130943", "John", "Wick", "9728104917", "Middle O' Nowhere");
		Contact test2 = new Contact("10346854", "Bruce", "Wayne", "2301740593", "Batcave Cherry Dr");
		Contact test3 = new Contact("2971479", "Snoop", "Dogg", "1384034817", "Malibu Beach");
		
		assertTrue(cs.addContact(test1));
		assertTrue(cs.addContact(test2));
		assertTrue(cs.addContact(test3));
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			cs.updateContact("130943", "", "Wick", "9728104917", "Middle O' Nowhere");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			cs.updateContact("10346854", "Bruce", "", "2301740593", "Batcave Cherry Dr");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			cs.updateContact("2971479", "Snoop", "Dogg", "", "Malibu Beach");
		});
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			cs.updateContact("130943", "John", "Wick", "9728104917", "");
		});
	}

}
