package Mobile_application;
import java.util.ArrayList;

public class ContactService {
	
	private ArrayList<Contact> contacts;
	
	public ContactService() {
		
		contacts = new ArrayList<>();
	}
	
	public boolean addContact(Contact contact) {
		boolean contactExists = false;
		
		for (Contact currContact : contacts) {
			
			if (currContact.getContactID().equals(contact.getContactID())) {
				contactExists = true;
			}
		}
		
		if (!contactExists) {
			
			contacts.add(contact);
			return true;
		}
		else {
			System.out.println("Contact " + contact.getContactID() + " already exists");
			return false;
		}
	}
	
	public boolean deleteContact(String contactID) {
		
		for (Contact currContact : contacts) {
			
			if (currContact.getContactID().equals(contactID)) {
				
				contacts.remove(currContact);
				return true;
			}
		}
		System.out.println("Contact " + contactID + " is not in the list");
		return false;
	}
	
	public boolean updateContact(String contactID, String firstName, String lastName, String phone, String address) {
		
		for (Contact currContact : contacts) {
			
			if (currContact.getContactID().equals(contactID)) {
				
				if (firstName.equals("") || (firstName.length() > 10)) {
					
					throw new IllegalArgumentException("Invalid first name entry");
				}
				
				if (lastName.equals("") || (lastName.length() > 10)) {
					
					throw new IllegalArgumentException("Invalid last name entry");
				}
				
				if (phone.equals("") || !(phone.length() == 10)) {
					
					throw new IllegalArgumentException("Invalid phone number entry");
				}
				
				if (address.equals("") || (address.length() > 30)) {
					
					throw new IllegalArgumentException("Invalid email address entry");
				}
				currContact.setFirstName(firstName);
				currContact.setLastName(lastName);
				currContact.setPhone(phone);
				currContact.setAddress(address);
				return true;
			}
		}
		System.out.println("Failed to update contact " + contactID);
		return false;
	}
}
